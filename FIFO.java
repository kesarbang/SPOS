import java.util.*;

public class FIFO
{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n,frames,currentPage;

		System.out.println("Enter number of pages");
		n = sc.nextInt();
		System.out.println("Enter number of frames");
		frames = sc.nextInt();

		int pages[] = new int[n];
		System.out.println("Enter reference string");
		for(int i=0;i<n;i++)
		{
			pages[i]=sc.nextInt();
		}

		ArrayList<Integer> frameList = new ArrayList<>(frames);
		
		int pageFault = 0;
		int pageHit=0;
		
		for(int i=0;i<frames;i++)
		{
			frameList.add(-1);
		}

		System.out.println("Page\tFrames\t\t\tPage Fault");
		int indexToR =0;
		for(int i=0;i<n;i++)
		{
			currentPage = pages[i];
			if(!frameList.contains(currentPage))
			{
				
				if(frameList.size() == frames)
				{
					frameList.set(indexToR,currentPage);
					indexToR = (indexToR+1)%frames;

				}
				else
				{
					frameList.add(currentPage);

				}										
				pageFault ++;	
				
				System.out.println(pages[i]+"\t"+frameList+"\t\t"+"Yes");
				
			}
			else
			{
				System.out.println(pages[i]+"\t"+frameList+"\t\t"+"No");
				pageHit ++;
			}
	
		}
		
		System.out.println("Total number of PageFaults :"+pageFault);
		System.out.println("Total number of PageHits :"+pageHit);

	}
}