/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.fangv.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import frc.fangv.robot.commands.*;
import frc.fangv.robot.subsystems.CameraSubsystem;
import frc.fangv.robot.subsystems.ControlPanelSubsystem;
import frc.fangv.robot.subsystems.DriveTrainSubsystem;
import frc.fangv.robot.subsystems.HookAndWinchSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    private final DriveTrainSubsystem driveTrain = DriveTrainSubsystem.getInstance();
    private final CameraSubsystem camera = CameraSubsystem.getInstance();
    private final ControlPanelSubsystem controlPanel = ControlPanelSubsystem.getInstance();
    private final HookAndWinchSubsystem hookAndWinch = HookAndWinchSubsystem.getInstance();

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */
    private void configureButtonBindings()
    {

        oi  = new OperatorInput();

        /** Control Panel Stuff */
        JoystickButton controlPanelForwardButton =
                new JoystickButton(OperatorInput.getDriverStick(),Constants.CONTROLPANELWHEELFORWARDBUTTON);
        JoystickButton controlPanelBackwardButton =
                new JoystickButton(OperatorInput.getDriverStick(),Constants.CONTROLPANELWHEELBACKWARDBUTTON);
        controlPanelBackwardButton.whileHeld(new ControlPanelWheelBackwardCommand(controlPanel));
        controlPanelForwardButton.whileHeld(new ControlPanelWheelForwardCommand(controlPanel));


        /** Hook And Winch Stuff */
        JoystickButton hookSolenoidExtendReleaseButton =
                new JoystickButton(OperatorInput.getDriverStick(),Constants.HOOKSOLENOIDEXTENDRELEASEBUTTON);
        JoystickButton winchMotorForwardButton =
                new JoystickButton(OperatorInput.getDriverStick(), Constants.WINCHMOTORFORWARDBUTTON);
        JoystickButton winchMotorBackwardButton =
                new JoystickButton(OperatorInput.getDriverStick(), Constants.WINCHMOTORBACKWARDBUTTON);
        hookSolenoidExtendReleaseButton.toggleWhenPressed
                (new ToggleHookSolenoidExtendReleaseCommand(hookAndWinch));
        winchMotorForwardButton.whileHeld(new WinchMotorForwardCommand(hookAndWinch));
        winchMotorBackwardButton.whileHeld(new WinchMotorBackwardCommand(hookAndWinch));

        JoystickButton changeFrontButton =
                new JoystickButton(OperatorInput.getDriverStick(), Constants.CHANGE_FRONT_BUTTON);
        JoystickButton toggleFrontButton = new JoystickButton(OperatorInput.getDriverStick(), Constants.TOGGLE_FRONT_BUTTON);
        toggleFrontButton.toggleWhenPressed(new ChangeFrontCommand(driveTrain));

    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // TODO: Change to auto
        return null;
    }
}
