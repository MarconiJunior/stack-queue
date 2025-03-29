package queue.patient;

public class Patient {
    private String name;
    private int queueId;

    public Patient(String name, int queueId) {
        this.setName(name);
        this.setQueueId(queueId);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getQueueId() {
        return queueId;
    }

    private void setQueueId(int queueId) {
        this.queueId = queueId;
    }
}
