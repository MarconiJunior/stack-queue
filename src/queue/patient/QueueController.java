package queue.patient;

import queue.Queue;

import java.util.Random;

public class QueueController {
    private final Queue<Patient> patientInQueue = new Queue<>();
    private final Queue<Patient> calledPatients = new Queue<>();
    private Patient lastCalledPatient;

    public QueueController() {}

    public Queue<Patient> getPatientInQueue() {
        return patientInQueue;
    }

    public Queue<Patient> getCalledPatients() {
        return calledPatients;
    }

    public Patient getLastCalledPatient() {
        return lastCalledPatient;
    }

    private void setLastCalledPatient(Patient lastCalledPatient) {
        this.lastCalledPatient = lastCalledPatient;
    }

    private int generatePatientId() {
        Random r = new Random(73654389);
        return r.nextInt();
    }

    public void registerAndEnqueuePatient(String name) {
        int queueId = generatePatientId();
        Patient patient = new Patient(name, queueId);
        getPatientInQueue().enqueue(patient);
        System.out.println("Patient " + name + " has been enqueued and queue id is " + queueId + ".");
    }

    public void callNextPatient() {
        Patient nextPatient = getPatientInQueue().dequeue().getValue();
        setLastCalledPatient(nextPatient);
        getCalledPatients().enqueue(nextPatient);
        System.out.println("Patient " + nextPatient.getName() + " has been called.");
    }
}
