package javaNormal.exception;

public class UserDefineException {
    public static void main(String[] args) {
        UserDefineException userDefineException = new UserDefineException();
        try{
            userDefineException.attack("");
            System.out.println("Attack successful");
        }catch (AttackException attackE){
            System.out.println("Exception reason: "+attackE.getMessage());
            attackE.printStackTrace();
        }

    }

    public void attack(String enemy) throws AttackException{
        if("".equals(enemy)){
            throw new AttackException("Enemy is not exist 1213");
        }
        System.out.println(enemy.toString());
    }

    class AttackException extends Exception{
        public AttackException(){
        }
        public AttackException(String errormsg){
            super(errormsg);
        }
    }
}

