package frc.fangv.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OperatorInput
{
    private static XboxController driverStick = new XboxController(0);
    private static XboxController coDriverStick = new XboxController(1);

    public static XboxController getDriverStick()
    {
        return driverStick;
    }
    public static XboxController getCodriverStick() { return driverStick; }
}
