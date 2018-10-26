import javax.swing.JOptionPane;

public class RenovationProjectManager2 {
	
	// Calculate cost of single wall
	public void singleWallMethod() {
		double wallArea = getArea(1);
		double cost = getCost(wallArea);
		JOptionPane.showMessageDialog(null, "Cost to paint a wall of " + wallArea + " sq.m is $" + cost);
	}

	// Calculate cost of multiple walls (plus while loops for additional walls)
	public void multipleWallMethod() {
		int wallCount = 0, moreWallsLeft = 0;
		double wallArea = 0, cost;

		while (moreWallsLeft == 0) {
			wallCount++;
			wallArea += getArea(wallCount);
			moreWallsLeft = Integer.parseInt(JOptionPane.showInputDialog("Enter 0 for more, 1 to finish"));
			while (moreWallsLeft < 0 || moreWallsLeft > 1) {
				moreWallsLeft = Integer.parseInt(JOptionPane.showInputDialog("Error! Enter 0 for more, 1 to finish"));
			}
		}
		cost = getCost(wallArea);
		JOptionPane.showMessageDialog(null,
				"Cost to paint " + wallCount + " wall(s) of total area " + wallArea + " sq.m is $" + cost);
	}

	// Calculate cost of single floor
	public void singleFloorMethod() {
		double area = getArea(1);
		double floorCost = getCost(area);

		JOptionPane.showMessageDialog(null, "Cost of materials for a single floor is $" + floorCost);

	}

	// Calculate cost of multiple floors (plus while loop for additional floors)
	public void multipleFloorMethod() {
		double floorArea = 0, moreFloorsLeft = 0, total = 0;
		int floorCount = 0;

		while (moreFloorsLeft == 0) {
			floorCount++;
			floorArea += getArea(floorCount);
			moreFloorsLeft = Integer.parseInt(JOptionPane.showInputDialog("Enter 0 for more, 1 to finish"));
			while (moreFloorsLeft < 0 || moreFloorsLeft > 1) {
				moreFloorsLeft = Integer.parseInt(JOptionPane.showInputDialog("Error! Enter 0 for more, 1 to finish"));
			}
		}
		total = getCost(floorArea);
		JOptionPane.showMessageDialog(null,
				"Cost of materials for " + floorCount + " floor(s) of total area " + floorArea + " sq.m is $" + total);
	}

	// Calculate generic surface area based on user inputs
	public double getArea(int areaNum) {
		double inputOne = Double
				.parseDouble(JOptionPane.showInputDialog("Enter first dimension (m) of area " + areaNum));
		double inputTwo = Double
				.parseDouble(JOptionPane.showInputDialog("Enter second dimension (m) of area " + areaNum));
		double Area = inputOne * inputTwo;
		return Area;
	}

	// Calculate material cost of generic area
	public double getCost(double area) {
		double input = Double.parseDouble(JOptionPane.showInputDialog("Enter cost ($) per unit (litre/m2)"));
		double cost = area * input;
		return cost;
	}

	// Menu - User chooses option from array of strings
	public String menu() {
		int i = 0;
		String input = "";
		String[] menu = { "1. Calculate cost of paint required for a single wall",
				"2. Calculate cost of paint required for entire project",
				"3. Calculate cost of floor material required for a single floor",
				"4. Calculate cost of floor material required for entire project" };

		while (i < 4) {
			input += menu[i] + "\n";
			i++;
		}
		input = JOptionPane.showInputDialog("Welcome! \nWhat would you like to do?\n\n" + input );
		return input;
	}

	// Main method
	public static void main(String[] args) {

		// Setting up methods
		RenovationProjectManager2 obj = new RenovationProjectManager2();

		// Calling menu method
		String tempInput = obj.menu();

		while (tempInput != null) {

			if (tempInput.contains("1")) {
				obj.singleWallMethod();
			} else if (tempInput.contains("2")) {
				obj.multipleWallMethod();
			} else if (tempInput.contains("3")) {
				obj.singleFloorMethod();
			} else if (tempInput.contains("4")) {
				obj.multipleFloorMethod();
			}

			else {
				JOptionPane.showMessageDialog(null, "Error - please enter a valid choice!");
			}
			tempInput = obj.menu();
		}
		JOptionPane.showMessageDialog(null, "Goodbye!");
	}
}