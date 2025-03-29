package queue.patient;

/**
 * Represents a patient in a queue system.
 */
public class Patient {
    private String name;
    private int queueId;

    /**
     * Constructs a new Patient with a specified name and queue ID.
     *
     * @param name The name of the patient.
     * @param queueId The ID representing the patient's seed.
     */
    public Patient(String name, int queueId) {
        this.setName(name);
        this.setQueueId(queueId);
    }

    /**
     * Retrieves the name of the patient.
     *
     * @return The patient's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the patient.
     *
     * @param name The name to set for the patient.
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the queue ID of the patient.
     *
     * @return The patient's queue ID.
     */
    public int getQueueId() {
        return queueId;
    }

    /**
     * Sets the queue ID for the patient.
     *
     * @param queueId The queue ID to set for the patient.
     */
    private void setQueueId(int queueId) {
        this.queueId = queueId;
    }
}
