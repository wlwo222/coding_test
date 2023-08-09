package programmers.sol_172928;

class Solution {
    int height = 0;
    int width = 0;
    public int[] solution(String[] park, String[] routes) {
        String[][] map = new String[park.length][park.length];
        RobotDog dog = new RobotDog();
        height = park.length;
        width = park[0].split("").length;

        for (int i = 0; i < park.length; i++) {
            String block = park[i];
            if (block.contains("S")) {
                char[] blocks = block.toCharArray();
                for (int j = 0; j < blocks.length; j++) {
                    char b = blocks[j];
                    if (b == 'S') {
                        dog.xPos = j;
                        dog.yPos = i;
                    }
                }
            }

            map[i] = block.split("");
        }

        for (String route : routes) {
            String direction = route.split(" ")[0];
            int move = Integer.parseInt(route.split(" ")[1]);

            dog.moving(direction, move, map);
        }

        return new int[]{dog.yPos, dog.xPos};
    }

    class RobotDog{
        int xPos;
        int yPos;

        void moving(String direction, int move, String[][] map) {
            boolean disable = false;
            switch (direction) {
                case "E":
                    if (xPos + move < width) {
                        String[] row = map[yPos];
                        for (int i = 1; i <= move; i++) {
                            String block = row[xPos + 1];
                            if (disable) break;
                            if (block.equals("X")) {
                                xPos -= i - 1;
                                disable = true;
                            } else {
                                xPos++;
                            }
                        }
                    }
                    break;
                case "S":
                    if (yPos + move < height) {
                        for (int i = 1; i <= move; i++) {
                            String block = map[yPos + 1][xPos];
                            if (disable) break;
                            if (block.equals("X")) {
                                yPos -= i - 1;
                                disable = true;
                            } else {
                                yPos++;
                            }
                        }

                    }
                    break;
                case "W":
                    if (0 <= xPos - move) {
                        String[] row = map[yPos];
                        for (int i = 1; i <= move; i++) {
                            if (disable) break;
                            String block = row[xPos - 1];
                            if (block.equals("X")) {
                                xPos += i - 1;
                                disable = true;
                            } else {
                                xPos--;
                            }
                        }
                    }
                    break;
                case "N":
                    if (0 <= yPos - move) {
                        for (int i = 1; i <= move; i++) {
                            if (disable) break;
                            String block = map[yPos - 1][xPos];
                            if (block.equals("X")) {
                                yPos += i - 1;
                                disable = true;
                            } else {
                                yPos--;
                            }
                        }
                    }
                    break;
            }

            disable = false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] park = {"XSX", "OOO", "XXO"};
        String[] routes = {"S 1", "E 1", "S 1", "S 1", "N 1", "E 2", "E 1", "N 1", "W 2", "E 1", "N 1"};
        int[] a = s.solution(park, routes);
        System.out.println(String.format("%s, %s", a[0], a[1]));
    }
}