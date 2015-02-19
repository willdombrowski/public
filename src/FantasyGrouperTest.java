import java.util.Vector;

public class FantasyGrouperTest {

	private static final String STR_SEPARATOR = "   ";
	static Double teams = 9.0;
	static Double groups = 3.0;
	static int startChar = 'A';
	static Vector<String> seasonGroupPool = new Vector<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");

		Double groupSize = teams / groups;

		System.out.println("Teams = " + teams.toString() + ", Groups = "
				+ groups.toString() + ", GroupSize = " + groupSize.toString());

		int level = 1;
		for (int i = 0; i < teams; i++) {
			recursiveTeam("" + (char) (i + startChar), level);
		}

		int totalSize = seasonGroupPool.size();
		System.out.println("total size: " + totalSize);
		System.out.println("theoretical maximum weeks supportable: "
				+ totalSize / groups);

		// System.out.println(seasonGroupPool);
		//Collections.reverse(seasonGroupPool);
		
		separateIntoSchedule(groupSize);
	}

	private static void recursiveTeam(String chStr, int level) {
		String[] chParts = chStr.split(",");
		int ch = (int) chParts[chParts.length - 1].charAt(0) - startChar;
		Double groupSize = teams / groups;

		boolean finished = false;
		for (int i = 0; i < teams; i++) {
			if (ch < i) {
				if (level == groupSize - 1) {
					String group = (chStr + "," + (char) (startChar + i));
					seasonGroupPool.add(group);
					System.out.print(group + STR_SEPARATOR);
					finished = true;
				} else {
					String group = (chStr + "," + (char) (startChar + i));
					recursiveTeam(group, level + 1);
				}
			}
		}
		if (finished)
			System.out.println();

	}

	private static void separateIntoSchedule(Double groupSize) {
		int indexToPull = -1;
		int lastSize = -1;
		int lastIndAdded = -1;
		int resultCount =1;
		while (seasonGroupPool.size() >= groupSize) {

			int size = seasonGroupPool.size();
						
			indexToPull++;
			if(indexToPull>=size-1){
				indexToPull=0;
				if(lastSize==0&&lastIndAdded==0){
					break;
				}
				lastSize = 0;
				lastIndAdded = 0;
			}
			
			String firstGroupOfWeek = seasonGroupPool.get(indexToPull);
			
			Vector<String> vList = new Vector<>();
			vList.add(firstGroupOfWeek);

			while (vList.size() < groups) {
				String comparePreviousGroups = "";
				for (String string : vList) {
					comparePreviousGroups += " " + string;
				}
				
				int vListSize = vList.size();
				for (String string : seasonGroupPool) {
					boolean hasMatch = false;
					String[] subSplit = string.split(",");
					for (String string2 : subSplit) {
						if (comparePreviousGroups.indexOf(string2.charAt(0)) >= 0) {
							hasMatch = true;
						}
					}
					if (!hasMatch) {
						vList.add(string);
						break;
					}
				
				}
				if(vListSize==vList.size()){
					break;//no moves
				}
				
			}
			if (vList.size() == groups) {
				lastIndAdded=indexToPull;
				lastSize=size;
				System.out.println(resultCount + ": "+ vList);
				resultCount++;
				for (String string : vList) {
					seasonGroupPool.remove(string);
				}
			}
			vList.clear();

		}
		System.out.println("remainder = " + seasonGroupPool.size()/groupSize + " weeks");

	}

}
