import rpn.CalculFinished;
import rpn.CalculateEvent;
import rpn.CalculatorEL;
import rpn.Event.*;

class TestEmiter extends EmiterListener {
    public TestEmiter(EventDispatcher eventDispatcher) {
        super(eventDispatcher);
    }
}

public class main{
    public static EventDispatcher eventDispatcher = new EventDispatcher();
    public static void main(String[] args) {
        CalculatorEL calculatorEL = new CalculatorEL(eventDispatcher);

        eventDispatcher.register("CalculFinished", new ICoffee<CalculFinished>() {
            @Override
            public void call(CalculFinished event) {
                System.out.println("Final result → ");
                for (String entity :
                        event.calcul) {
                    System.out.println(" " + entity);
                }

            }
        });

        eventDispatcher.emit(new CalculateEvent("2 a + 1"));

    }
}
