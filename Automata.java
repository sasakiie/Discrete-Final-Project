public class Automata {
    private State currentState;

    public Automata(){
        currentState = State.START;
    }

    public void processInput(String input){
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            switch (currentState) {
                case START:
                    if (currentChar == '1') {
                        currentState = State.START;
                    }
                    if (currentChar == '0') {
                        currentState = State.STATE_1;
                    }
                    else{
                        currentState = State.REJECT;
                    }
                    break;
                case STATE_1:
                    if (currentChar == '0') {
                        currentState = State.STATE_1;
                    }
                    if (currentChar == '1') {
                        currentState = State.ACCEPT;
                    }
                    break;
                case ACCEPT:
                    if (currentChar == '1') {
                        currentState = State.START;
                    }
                    if (currentChar == '0') {
                        currentState = State.STATE_1;  
                    }
                    break;
                case REJECT:{break;}
            }
            
        }
    }
    
    public boolean isAccepted(){
        return currentState == State.ACCEPT;
    }

    
}
