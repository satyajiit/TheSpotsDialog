package com.satyajit.thespotsdialog;

import android.animation.*;

/**
 *  Created on 24th Feb 2019
 *  Satyajit Pradhan
 *  It is a update to D-max Spots Dialog
 */

class AnimatorPlayer extends AnimatorListenerAdapter {

    private boolean interrupted = false;
    private Animator[] animators;

    AnimatorPlayer(Animator[] animators) {
        this.animators = animators;
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if (!interrupted) animate();
    }

    void play() {
        animate();
    }

    void stop() {
        interrupted = true;
    }

    private void animate() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animators);
        set.addListener(this);
        set.start();
    }
}
