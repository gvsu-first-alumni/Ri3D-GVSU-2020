package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.OperatorInput;
import frc.fangv.robot.subsystems.DriveTrainSubsystem;

import java.util.Set;

public class DriveCommand implements Command
{
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final Set<Subsystem>      subsystems;

    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem)
    {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.subsystems = Set.of(driveTrainSubsystem);
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {
        System.out.println(driveTrainSubsystem.getLeftDistance() + "\t" + driveTrainSubsystem.getRightDistance());
        driveTrainSubsystem.tankDrive(
                OperatorInput.getDriverStick().getY(GenericHID.Hand.kLeft),
                OperatorInput.getDriverStick().getY(GenericHID.Hand.kRight));
    }

    @Override
    public boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {

    }

    @Override
    public Set<Subsystem> getRequirements()
    {
        return this.subsystems;
    }
}
