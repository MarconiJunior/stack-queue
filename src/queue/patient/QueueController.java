package queue.patient;

import queue.Queue;

import java.util.Random;

/**
 * Manages the queue of patients and handles enqueueing, calling, and tracking patients.
 * It keeps track of patients waiting in the queue and those who have been called.
 */
public class QueueController {
    private final Queue<Patient> patientInQueue = new Queue<>();
    private final Queue<Patient> calledPatients = new Queue<>();
    private Patient lastCalledPatient;

    public QueueController() {}

    /**
     * Retrieves the queue of patients currently waiting.
     *
     * @return The queue of patients waiting to be called.
     */
    public Queue<Patient> getPatientInQueue() {
        return patientInQueue;
    }

    /**
     * Retrieves the queue of patients who have already been called.
     *
     * @return The queue of called patients.
     */
    public Queue<Patient> getCalledPatients() {
        return calledPatients;
    }

    /**
     * Retrieves the last patient that was called.
     *
     * @return The last called patient.
     */
    public Patient getLastCalledPatient() {
        return lastCalledPatient;
    }

    /**
     * Sets the last called patient.
     *
     * @param lastCalledPatient The patient to set as the last called.
     */
    private void setLastCalledPatient(Patient lastCalledPatient) {
        this.lastCalledPatient = lastCalledPatient;
    }

    /**
     * Generates a random ID for a patient.
     *
     * @return A randomly generated integer ID for a patient.
     */
    private int generatePatientId() {
        Random r = new Random(73654389);
        return r.nextInt();
    }

    /**
     * Registers a new patient and adds them to the waiting queue.
     *
     * @param name The name of the patient.
     */
    public void registerAndEnqueuePatient(String name) {
        int queueId = generatePatientId();
        Patient patient = new Patient(name, queueId);
        getPatientInQueue().enqueue(patient);
        System.out.println("Patient " + name + " has been enqueued and queue id is " + queueId + ".");
    }

    /**
     * Calls the next patient in the queue and moves them to the called queue.
     */
    public void callNextPatient() {
        Patient nextPatient = getPatientInQueue().dequeue().getValue();
        setLastCalledPatient(nextPatient);
        getCalledPatients().enqueue(nextPatient);
        System.out.println("Patient " + nextPatient.getName() + " has been called.");
    }
}
