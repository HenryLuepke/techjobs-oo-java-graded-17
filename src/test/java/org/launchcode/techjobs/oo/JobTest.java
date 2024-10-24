package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertEquals("Product tester", testJob.getName());

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job testJob2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(testJob1 == testJob2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String result = testJob.toString();

        assertTrue(result.startsWith(System.lineSeparator()));

        assertTrue(result.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Scanner scanner = new Scanner(testJob.toString());
        scanner.nextLine();

        assertEquals("ID: 4", scanner.nextLine()); // ask about best practice here, best to pass on full suite or single test?
        assertEquals("Name: Product tester", scanner.nextLine());
        assertEquals("Employer: ACME", scanner.nextLine());
        assertEquals("Location: Desert", scanner.nextLine());
        assertEquals("Position Type: Quality control", scanner.nextLine());
        assertEquals("Core Competency: Persistence", scanner.nextLine());

        scanner.close();
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType(""),
                new CoreCompetency("Persistence"));

        Scanner scanner = new Scanner(testJob.toString());
        scanner.nextLine();

        assertEquals("ID: 3", scanner.nextLine()); // ask about best practice here, best to pass on full suite or single test?
        assertEquals("Name: Product tester", scanner.nextLine());
        assertEquals("Employer: Data not available", scanner.nextLine());
        assertEquals("Location: Desert", scanner.nextLine());
        assertEquals("Position Type: Data not available", scanner.nextLine());
        assertEquals("Core Competency: Persistence", scanner.nextLine());

        scanner.close();
    }

}
