import java.util.*;

public class LRU {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, frames, currentPage;

        System.out.println("Enter number of pages");
        n = sc.nextInt();
        System.out.println("Enter number of frames");
        frames = sc.nextInt();

        int pages[] = new int[n];
        System.out.println("Enter reference string");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        ArrayList<Integer> frameList = new ArrayList<>(frames);
        for (int i = 0; i < frames; i++) {
            frameList.add(-1); 
        }

        int pageFault = 0;
        int pageHit = 0;
        HashMap<Integer, Integer> lastUsed = new HashMap<>(); // to track last used time

        System.out.println("Page\tFrames\t\t\tPage Fault");

        for (int i = 0; i < n; i++) {
            currentPage = pages[i];

            if (!frameList.contains(currentPage)) {
                if (frameList.contains(-1)) {
                    int emptyIndex = frameList.indexOf(-1);
                    frameList.set(emptyIndex, currentPage);
                } else {
  
                    int lruPage = frameList.get(0);
                    int min = lastUsed.get(lruPage);

                    for (int page : frameList) {
                        if (lastUsed.get(page) < min) {
                            min = lastUsed.get(page);
                            lruPage = page;
                        }
                    }

                    int replaceIndex = frameList.indexOf(lruPage);
                    frameList.set(replaceIndex, currentPage);
                }

                pageFault++;
                System.out.println(currentPage + "\t" + frameList + "\t\tYes");
            } else {

                pageHit++;
                System.out.println(currentPage + "\t" + frameList + "\t\tNo");
            }

            lastUsed.put(currentPage, i);
        }

        System.out.println("Total number of PageFaults :" + pageFault);
        System.out.println("Total number of PageHits :" + pageHit);
    }
}
