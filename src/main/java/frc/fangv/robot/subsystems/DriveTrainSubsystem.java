package frc.fangv.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.Constants;
import frc.fangv.robot.commands.DriveCommand;

public class DriveTrainSubsystem implements Subsystem
{
    // jus do et
    private DifferentialDrive drive;
    private CANSparkMax       left;
    private CANSparkMax       right;

    private boolean isForward;

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    private boolean isFired = false;

    /**
     * The Singleton instance of this DriveTrainSubsystem. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static DriveTrainSubsystem INSTANCE = new DriveTrainSubsystem();

    /**
     * Creates a new instance of this DriveTrainSubsystem.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private DriveTrainSubsystem()
    {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        setDefaultCommand(new DriveCommand(this));
        this.left = new CANSparkMax(Constants.LEFT_DRIVE, CANSparkMaxLowLevel.MotorType.kBrushless);
        this.right = new CANSparkMax(Constants.RIGHT_DRIVE, CANSparkMaxLowLevel.MotorType.kBrushless);
        this.left.getEncoder().setInverted(false);
        this.right.getEncoder().setInverted(false);
        this.drive = new DifferentialDrive(this.left, this.right);
    }

    public void tankDrive(double left, double right) {
        if (isForward()) {
            double temp = -left;
            left = -right;
            right = temp;
        }
        if (isFired){ drive.tankDrive(-0.5*left, -0.5*right); }
        else { drive.tankDrive(-left, -right);}
    }

    public boolean isForward()
    {
        return isForward;
    }

    public void setForward(boolean forward)
    {
        isForward = forward;
    }

    public double getLeftDistance() {
        return this.left.getEncoder().getPosition();
    }

    public double getRightDistance() {
        return  this.right.getEncoder().getPosition();
    }

    /**
     * Returns the Singleton instance of this DriveTrainSubsystem. This static method
     * should be used -- {@code DriveTrainSubsystem.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static DriveTrainSubsystem getInstance() { return INSTANCE; }

}

