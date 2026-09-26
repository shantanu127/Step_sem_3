abstract class Content {
    private final String contentId;
    private String title;

    public Content(String contentId, String title) {
        this.contentId = contentId;
        this.title = title;
    }

    public String getContentId() {
        return contentId;
    }

    public String getTitle() {
        return title;
    }

    public abstract String publish();
}

interface Shareable {
    String share(String platform);
}

class Article extends Content implements Shareable {
    private String author;

    public Article(String contentId, String title, String author) {
        super(contentId, title);
        this.author = author;
    }

    @Override
    public String publish() {
        return "Publishing Article: " + getTitle() + " by " + author;
    }

    @Override
    public String share(String platform) {
        return "Sharing Article [" + getTitle() + "] on " + platform;
    }
}

class Video extends Content implements Shareable {
    private int durationMinutes;

    public Video(String contentId, String title, int durationMinutes) {
        super(contentId, title);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String publish() {
        return "Publishing Video: " + getTitle() + " (" + durationMinutes + " mins)";
    }

    @Override
    public String share(String platform) {
        return "Sharing Video [" + getTitle() + "] on " + platform;
    }
}

public class PublishingManager {

    public static String processPublishingBatch(Content[] items, String platform) {
        if (items == null) {
            return "0 processed | 0 null skipped | 0 shareable";
        }

        int processedCount = 0;
        int nullCount = 0;
        int shareableCount = 0;

        for (Content item : items) {
            if (item == null) {
                nullCount++;
                continue;
            }

            processedCount++;

            if (item instanceof Shareable) {
                shareableCount++;
            }
        }

        return String.format("%d processed | %d null skipped | %d shareable",
                processedCount, nullCount, shareableCount);
    }
}