interface Controller {
    void pressButton(String button);
}

interface MotionController extends Controller {
    void tilt(String direction);
}

class Gamepad implements Controller {
    @Override
    public void pressButton(String button) {
        System.out.println("Button pressed: " + button);
    }
}

class VRMotionController implements MotionController {
    @Override
    public void pressButton(String button) {
        System.out.println("VR Button pressed: " + button);
    }

    @Override
    public void tilt(String direction) {
        System.out.println("Tilted motion controller: " + direction);
    }
}