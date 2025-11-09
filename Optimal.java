import java.util.*;

public class OptimalPageReplacement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of pages:");
        int n = sc.nextInt();

        System.out.println("Enter number of frames:");
        int framesCount = sc.nextInt();

        int pages[] = new int[n];
        System.out.println("Enter reference string:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        ArrayList<Integer> frameList = new ArrayList<>(framesCount);
        for (int i = 0; i < framesCount; i++) {
            frameList.add(-1); 
        }

        int pageFault = 0, pageHit = 0;

        System.out.println("\nPage\tFrames\t\t\tPage Fault");
        for (int i = 0; i < n; i++) {
            int currentPage = pages[i];

            if (!frameList.contains(currentPage)) {
                
                if (frameList.contains(-1)) {
                    
                    int empty = frameList.indexOf(-1);
                    frameList.set(empty, currentPage);
                } else {
                    
                    int farthest = -1;
                    int indexToReplace = -1;

                    for (int j = 0; j < framesCount; j++) {
                        int pageInFrame = frameList.get(j);
                        int nextUse = Integer.MAX_VALUE;

                        
                        for (int k = i + 1; k < n; k++) {
                            if (pages[k] == pageInFrame) {
                                nextUse = k;
                                break;
                            }
                        }

                        if (nextUse > farthest) {
                            farthest = nextUse;
                            indexToReplace = j;
                        }
                    }

                    frameList.set(indexToReplace, currentPage);
                }

                pageFault++;
                System.out.println(currentPage + "\t" + frameList + "\t\tYes");
            } else {
                
                pageHit++;
                System.out.println(currentPage + "\t" + frameList + "\t\tNo");
            }
        }

        System.out.println("\nTotal Page Faults: " + pageFault);
        System.out.println("Total Page Hits: " + pageHit);
    }
}
