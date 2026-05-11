class Solution {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();
        Integer scoreSum = 0;
        for (String op: operations) {
            executeOp(scores, op);
        }
        for (Integer score: scores) {
            scoreSum += score;
        }
        return scoreSum;
    }

    private void executeOp(List<Integer> scores, String op) {
        switch (op) {
            case "D":
                int a = scores.get(scores.size()-1);
                scores.add(2*a);
                break;
            case "+":
                int c = scores.get(scores.size()-1);
                int b = scores.get(scores.size()-2);
                scores.add(c+b);
                break;
            case "C":
                scores.remove(scores.size()-1);
                break;
            default:
                scores.add(Integer.parseInt(op));
                break;
        }
    }
}