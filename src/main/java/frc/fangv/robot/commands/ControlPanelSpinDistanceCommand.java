package frc.fangv.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.subsystems.ControlPanelSubsystem;

import java.util.Set;

public class ControlPanelSpinDistanceCommand implements Command {
    private final ControlPanelSubsystem controlPanelSubsystem;
    private final Set<Subsystem> subsystems;

    private double distanceBetweenColors = 0;

    public double getDistanceBetweenColors() {
        return distanceBetweenColors;
    }

    public void setDistanceBetweenColors(double distanceBetweenColors) {
        this.distanceBetweenColors = distanceBetweenColors;
    }

    

    public ControlPanelSpinDistanceCommand(ControlPanelSubsystem controlPanelSubsystem, double distanceBetweenColors) {
        this.distanceBetweenColors = distanceBetweenColors;
        this.controlPanelSubsystem = controlPanelSubsystem;
        this.subsystems = Set.of(controlPanelSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
