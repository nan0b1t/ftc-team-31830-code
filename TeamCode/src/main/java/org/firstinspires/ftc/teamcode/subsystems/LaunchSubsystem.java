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

    private boolean isToggled;

    public void init(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Initalizing launch subsystem...");
        iHandler.registerAction("Toggle Launcher", new InputAction(
                        InputHandler.Button.Y,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.WAS_PRESSED
                    ));
    }

    public void update(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        if (iHandler.actionHappened("Toggle Launcher")) {
            if (isToggled) {
                robot.revLauncher();
            } else if (!isToggled) {
                robot.stopLauncher();
            }
            isToggled = !isToggled;
        }
    }

    public void terminate(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Terminating launch system...");
    }
}
