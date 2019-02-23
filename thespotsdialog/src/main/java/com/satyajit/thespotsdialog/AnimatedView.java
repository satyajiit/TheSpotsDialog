package com.satyajit.thespotsdialog;

import android.content.Context;
import android.view.View;

/**
 *  Created on 24th Feb 2019
 *  Satyajit Pradhan
 *  It is a update to D-max Spots Dialog
 */

class AnimatedView extends View {

    private int target;

    public AnimatedView(Context context) {
        super(context);
    }

    public float getXFactor() {
        return getX() / target;
    }

    public void setXFactor(float xFactor) {
        setX(target * xFactor);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }
}
