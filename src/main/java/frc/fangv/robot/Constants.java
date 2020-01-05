/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.fangv.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    public static final double RAMP_MOTOR_SPEED = 0;
    public static final double RAMP_MOTOR_STOP = 0;
    public static final int RAMP_MOTOR_BUTTON = 1;
    public static final int RAMP_MOTOR_ID = 1;

    public static final int RAMP_FORWARD_CHANNEL = 0;
    public static final int RAMP_REVERSE_CHANNEL = 1;
    public static final int RAMP_GATE_BUTTON = 2;

    /** Control Panel Stuff */
    public static final double FORWARDSPEED = 0.75;
    public static final double BACKWARDSPEED = -0.075;
    public static final double STOPSPEED = 0.0;
    public static final int CONTROLPANELWHEELFORWARDBUTTON = 5;
    public static final int CONTROLPANELWHEELBACKWARDBUTTON = 6;

    /** Hook and Winch Stuff */
    public static final int HOOK_CHANNEL = 0;
    public static final int WINCH_CHANNEL = 1;
    public static final double WINCHMOTORSPEEDFORWARD = 0.75;
    public static final double WINCHMOTORSPEEDBACKWARD = -0.75;
    public static final double WINCHMOTORSTOP = 0.0;
    public static final int HOOKSOLENOIDEXTENDRELEASEBUTTON = 9;
    public static final int WINCHMOTORFORWARDBUTTON = 7;
    public static final int WINCHMOTORBACKWARDBUTTON = 5;

    public final static double CONTROL_PANEL_PID_P = 1.0;
    public final static double CONTROL_PANEL_PID_I = 0.0;
    public final static double CONTROL_PANEL_PID_D = 0.0;

    public final static int LEFT_DRIVE = 5;
    public final static int RIGHT_DRIVE = 4;
    public final static int TOGGLE_FRONT_BUTTON = 5;

    public final static double TICKS_PER_INCH = 23.8;
}