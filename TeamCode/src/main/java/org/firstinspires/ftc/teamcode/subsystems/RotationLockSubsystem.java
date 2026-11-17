package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.Subsystem;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.InputHandler;
import org.firstinspires.ftc.teamcode.InputAction;


public class RotationLockSubsystem implements Subsystem {
    public String getName() {
        return "Rot Lock System";
    }

    public void init(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Initalizing rotation subsystem...");
        iHandler.registerAction("Snap Left", new InputAction(
                        InputHandler.Button.LEFT_BUMPER,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.WAS_PRESSED
                    ));

        iHandler.registerAction("Snap Right", new InputAction(
                        InputHandler.Button.RIGHT_BUMPER,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.WAS_PRESSED
                    ));
    }

    public void update(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        double deg = robot.getRotationDegrees();
        if (iHandler.actionHappened("Snap Left")) {
            if (deg > 0 && deg < 90) {

            }
        }
    }

    public void terminate(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Terminating intake system...");
    }
}
