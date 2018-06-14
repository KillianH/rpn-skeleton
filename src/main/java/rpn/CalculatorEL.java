package rpn;

import rpn.Event.EmiterListener;
import rpn.Event.Event;
import rpn.Event.EventDispatcher;
import rpn.Event.ICoffee;
import rpn.EventOperator.*;
import rpn.EventParser.ParseFinishedEvent;
import rpn.EventParser.ParserEL;
import rpn.EventParser.ParserEvent;
import rpn.Operator.*;
import rpn.Parser.Parser;
import rpn.exceptions.ErrorEL;
import rpn.exceptions.ErrorEvent;
import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Observable;

public class CalculatorEL extends EmiterListener {
    private ArrayList<IOperatorEL> operations = new ArrayList<>();
    private ParserEL parser;
    private EventDispatcher eventDispatcher;
    private ErrorEL errors;

    public CalculatorEL(EventDispatcher eventDispatcher){
        super(eventDispatcher);
        operations.add(new AdditionEL(eventDispatcher));
        operations.add(new SubstractionEL(eventDispatcher));
        operations.add(new MultiplicationEL(eventDispatcher));
        operations.add(new DivisionEL(eventDispatcher));
        parser = new ParserEL(eventDispatcher);
        errors = new ErrorEL(eventDispatcher);

        register("CalculateEvent", new ICoffee<CalculateEvent>() {
            @Override
            public void call(CalculateEvent event) {
                emit(new ParserEvent(event.calcul));
            }
        });

        register("ParseFinishedEvent", new ICoffee<ParseFinishedEvent>() {
            @Override
            public void call(ParseFinishedEvent event) {
                emit(new PerformCalculEvent(event.tokens));
            }
        });

        register("PerformCalculEvent", new ICoffee<PerformCalculEvent>(){
            @Override
            public void call(PerformCalculEvent event) {
                ArrayList<String> calcul = event.calcul;
                for(int i = 0; i < calcul.size(); i++){
                    String token = calcul.get(i);
                    for(int operatorI = 0; operatorI < operations.size(); operatorI++){
                        if(token.equals(operations.get(operatorI).getOperator())){
                            Class operatorClass = operations.get(operatorI).getEventClass();
                            Class[] types       = {ArrayList.class, int.class};
                            Constructor eventConstructor;
                            try {
                                eventConstructor = operatorClass.getConstructor(types);
                                emit((Event) eventConstructor.newInstance(calcul, i));
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                errors.emit(new ErrorEvent(e));
                            }
                        }
                    }
                }
                emit(new CalculFinished(event.calcul));
            }
        });

        register("OperationAppliedEvent", new ICoffee<OperationAppliedEvent>() {
            @Override
            public void call(OperationAppliedEvent event) {
                System.out.println("intermediary result → ");
                for (String entity :
                        event.result) {
                    System.out.println(entity + " ");
                }

                emit(new PerformCalculEvent(event.result));
            }
        });
    }

    private String beautifyResponse(ArrayList<String> toBeauty){
        StringBuffer res = new StringBuffer();

        for(String token : toBeauty){
            res.append(" " + token);
        }

        return res.toString().trim();
    }

}
