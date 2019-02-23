package com.satyajit.thespotsdialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.TextView;

/**
 *  Created on 24th Feb 2019
 *  Satyajit Pradhan
 *  It is a update to D-max Spots Dialog
 */

public class SpotsDialog extends AlertDialog {



    public static class Builder {

        private Context context;
        private String message;
        private int messageId;
        private int themeId;
        private Typeface typeface;
        private boolean cancelable = true; // default dialog behaviour
        private OnCancelListener cancelListener;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setTypeface(Typeface typeface) {
            this.typeface = typeface;

            return this;
        }


        public Builder setMessage(@StringRes int messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setTheme(@StyleRes int themeId) {
            this.themeId = themeId;
            return this;
        }



        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setCancelListener(OnCancelListener cancelListener) {
            this.cancelListener = cancelListener;
            return this;
        }

        public AlertDialog build() {
            return new SpotsDialog(
                                context,
                                messageId != 0 ? context.getString(messageId) : message,
                                themeId != 0 ? themeId : R.style.SpotsDialogDefault,
                                cancelable,
                    cancelListener,
                    typeface
                        );
        }
    }

    private static final int DELAY = 150;
    private static final int DURATION = 1500;

    private int size;
    private AnimatedView[] spots;
    private AnimatorPlayer animator;
    private CharSequence message;
    private Typeface typeface;


    private SpotsDialog(Context context, String message, int theme, boolean cancelable, OnCancelListener cancelListener, Typeface typeface) {
        super(context, theme);
        this.message = message;
        this.typeface = typeface;


        setCancelable(cancelable);
        if (cancelListener != null) setOnCancelListener(cancelListener);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.the_spots_dialog);
        setCanceledOnTouchOutside(false);

        if (typeface == null)
        typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/cav.ttf");

        initMessage();

        initProgress();



    }

    @Override
    protected void onStart() {
        super.onStart();

        for (AnimatedView view : spots) view.setVisibility(View.VISIBLE);

        animator = new AnimatorPlayer(createAnimations());
        animator.play();
    }

    @Override
    protected void onStop() {
        super.onStop();

        animator.stop();
    }

    @Override
    public void setMessage(CharSequence message) {
        this.message = message;
        if (isShowing()) initMessage();
    }

    //~

    private void initMessage() {
        if (message != null && message.length() > 0) {
            ((TextView) findViewById(R.id.dialog_spots_title)).setText(message);
            ((TextView) findViewById(R.id.dialog_spots_title)).setTypeface(typeface);
        }
    }

    private void initProgress() {
        ProgressLayout progress = findViewById(R.id.dialog_spots_progress);
        size = progress.getSpotsCount();

        spots = new AnimatedView[size];
        int size = getContext().getResources().getDimensionPixelSize(R.dimen.spot_size);
        int progressWidth = getContext().getResources().getDimensionPixelSize(R.dimen.progress_width);
        for (int i = 0; i < spots.length; i++) {
            AnimatedView v = new AnimatedView(getContext());
            v.setBackgroundResource(R.drawable.the_dialog_spot);
            v.setTarget(progressWidth);
            v.setXFactor(-1f);
            v.setVisibility(View.INVISIBLE);
            progress.addView(v, size, size);
            spots[i] = v;
        }
    }

    private Animator[] createAnimations() {
        Animator[] animators = new Animator[size];
        for (int i = 0; i < spots.length; i++) {
            final AnimatedView animatedView = spots[i];
            Animator move = ObjectAnimator.ofFloat(animatedView, "xFactor", 0, 1);
            move.setDuration(DURATION);
            move.setInterpolator(new HesitateInterpolator());
            move.setStartDelay(DELAY * i);
            move.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    animatedView.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationStart(Animator animation) {
                    animatedView.setVisibility(View.VISIBLE);
                }
            });
            animators[i] = move;
        }
        return animators;
    }
}
