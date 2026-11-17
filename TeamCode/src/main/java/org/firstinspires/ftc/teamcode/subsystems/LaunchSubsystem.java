package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.Subsystem;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.InputHandler;
import org.firstinspires.ftc.teamcode.InputAction;


public class LaunchSubsystem implements Subsystem {
    public String getName() {
        return "Launch System";
    }

    private static final double MIN_VELOCITY = 0;
    private static final double MAX_VELOCITY = 2500;
    private static final double VELOCITY_STEP = 50;

    private boolean isToggled;
    private boolean isWindmillToggled;

    private double velocity = 1300;

    public void init(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Initalizing launch subsystem...");
        iHandler.registerAction("Toggle Launcher", new InputAction(
                        InputHandler.Button.Y,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.WAS_PRESSED
                    ));

        iHandler.registerAction("Toggle Windmill", new InputAction(
                        InputHandler.Button.B,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.WAS_PRESSED
                    ));

        iHandler.registerAction("Decrease Velocity", new InputAction(
                        InputHandler.Button.LEFT_BUMPER,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.IS_PRESSED
                    ));

        iHandler.registerAction("Increase Velocity", new InputAction(
                        InputHandler.Button.RIGHT_BUMPER,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.IS_PRESSED
                    ));
    }

    public void update(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        if (iHandler.actionHappened("Toggle Launcher")) {
            isToggled = !isToggled;
            if (isToggled) {
                robot.revLauncher(velocity);
            } else {
                robot.stopLauncher();
            }
        }

        if (iHandler.actionHappened("Toggle Windmill")) {
            isWindmillToggled = !isWindmillToggled;
            if (isWindmillToggled) {
                robot.startWindmill();
            } else {
                robot.stopWindmill();
            }
        }

        if (iHandler.actionHappened("Increase Velocity")) {
            velocity = Math.max(MIN_VELOCITY, velocity + VELOCITY_STEP);
            if (isToggled) {
                robot.revLauncher(velocity);
            }
        }
        if (iHandler.actionHappened("Decrease Velocity")) {
            velocity = Math.min(MAX_VELOCITY, velocity - VELOCITY_STEP);
            if (isToggled) {
                robot.revLauncher(velocity);
            }
        }

        telemetry.addData("Launch Velocity Target: ", velocity);
        telemetry.addData("Launch Velocity Actual: ", robot.getLauncherVelocity());
    }

    public void terminate(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Terminating launch system...");
    }
}
