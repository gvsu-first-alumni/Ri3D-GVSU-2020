package frc.fangv.robot.subsystems;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class CameraSubsystem implements Subsystem
{
    /**
     * The Singleton instance of this CameraSubsystem. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static CameraSubsystem INSTANCE = new CameraSubsystem();

    /**
     * Creates a new instance of this CameraSubsystem.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private CameraSubsystem()
    {
        CameraServer.getInstance().startAutomaticCapture()
                .setResolution(640, 360);
    }

    /**
     * Returns the Singleton instance of this CameraSubsystem. This static method
     * should be used -- {@code CameraSubsystem.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static CameraSubsystem getInstance() { return INSTANCE; }
}

