package math;

public abstract class UnaryOperation implements Operation{

        final protected Operation op;

        public UnaryOperation(Operation op) {

            this.op = op;
        }

        public Operation getOp() {
            return op;
        }

}
