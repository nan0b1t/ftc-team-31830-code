package org.firstinspires.ftc.teamcode;

public class Actions {
    public static void assignActions(InputHandler ih) {
        ih.registerAction("Test Action", new InputAction(InputHandler.Button.X,  InputHandler.GamepadNum.ONE, InputAction.InputType.WAS_PRESSED));
    }
}
