package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.Constants;
import frc.fangv.robot.subsystems.DriveTrainSubsystem;

import java.util.Set;

// CAN ONLY DO POSITIVE DISTANCES
public class DriveDistanceCommand implements Command
{
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final Set<Subsystem>      subsystems;
    private double distance;
    private double startLeft;
    private double startRight;

    public DriveDistanceCommand(DriveTrainSubsystem driveTrainSubsystem, double distance)
    {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.subsystems = Set.of(driveTrainSubsystem);
        this.distance = distance / Constants.INCH_PER_TICKS;
    }

    @Override
    public void initialize()
    {
        this.startLeft = driveTrainSubsystem.getLeftDistance();
        this.startRight = driveTrainSubsystem.getRightDistance();
    }

    @Override
    public void execute()
    {
        System.out.println(driveTrainSubsystem.getLeftDistance() + " \t " + driveTrainSubsystem.getRightDistance());
        driveTrainSubsystem.tankDrive(-.4, -.4);
    }

    @Override
    public boolean isFinished()
    {
        return driveTrainSubsystem.getLeftDistance() >= startLeft + distance ||
                driveTrainSubsystem.getRightDistance() >= startRight + distance;
    }

    @Override
    public void end(boolean interrupted)
    {
        driveTrainSubsystem.tankDrive(0,0);
    }

    @Override
    public Set<Subsystem> getRequirements()
    {
        return this.subsystems;
    }
}
