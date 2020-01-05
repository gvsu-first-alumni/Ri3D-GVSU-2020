package frc.fangv.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class OperatorInput
{
    private static XboxController driverStick = new XboxController(0);

    public static XboxController getDriverStick()
    {
        return driverStick;
    }
}
