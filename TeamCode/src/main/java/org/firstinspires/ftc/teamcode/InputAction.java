package org.firstinspires.ftc.teamcode;

public class InputAction {
    public InputHandler.Button input;
    public InputHandler.GamepadNum gamepad;
    public InputType inputType;

    public InputAction(InputHandler.Button input, InputHandler.GamepadNum gamepad, InputType inputType) {
        this.input = input;
        this.gamepad = gamepad;
        this.inputType = inputType;
    }

    public enum InputType {
        IS_PRESSED,
        WAS_PRESSED,
        WAS_RELEASED
    }
}
