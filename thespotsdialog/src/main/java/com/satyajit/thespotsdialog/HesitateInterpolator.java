package com.satyajit.thespotsdialog;

import android.view.animation.Interpolator;

/**
 *  Created on 24th Feb 2019
 *  Satyajit Pradhan
 *  It is a update to D-max Spots Dialog
 */

class HesitateInterpolator implements Interpolator {

    private static double POW = 1.0/2.0;

    @Override
    public float getInterpolation(float input) {
        return input < 0.5
                ? (float) Math.pow(input * 2, POW) * 0.5f
                : (float) Math.pow((1 - input) * 2, POW) * -0.5f + 1;
    }
}