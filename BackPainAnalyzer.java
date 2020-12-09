/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpaindecisiontree;

import java.io.*;

/**
 * Stephen Zoyac
 * 11/22/20
 * Decision Tree Completion Project.
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 */
public class BackPainAnalyzer
{
	/**
	 *  Asks questions of the user to diagnose a medical problem.
     * @param args
     * @throws java.io.FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("So, you're having back pain.");

		DecisionTree expert = new DecisionTree("input.txt");
		expert.evaluate();
	}
}
