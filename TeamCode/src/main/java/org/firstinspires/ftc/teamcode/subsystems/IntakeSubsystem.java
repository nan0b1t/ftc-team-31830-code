package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.Subsystem;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.InputHandler;
import org.firstinspires.ftc.teamcode.InputAction;


public class IntakeSubsystem implements Subsystem {
    public String getName() {
        return "Intake System";
    }

    private boolean isToggled;

    public void init(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Initalizing intake subsystem...");
        iHandler.registerAction("Toggle Intake", new InputAction(
                        InputHandler.Button.X,
                        InputHandler.GamepadNum.ONE,
                        InputAction.InputType.WAS_PRESSED
                    ));
    }

    public void update(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        if (iHandler.actionHappened("Toggle Intake")) {
            if (isToggled) {
                robot.stopIntake();
            } else if (!isToggled) {
                robot.runIntake();
            }
            isToggled = !isToggled;
        }
    }

    public void terminate(Telemetry telemetry, Robot robot, InputHandler iHandler) {
        telemetry.addLine("Terminating intake system...");
    }
}
