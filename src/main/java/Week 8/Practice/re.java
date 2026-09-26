import java.util.ArrayList;
import java.util.List;

abstract class LibraryResource {
    private final String resourceId;
    private final String title;
    private boolean isAvailable;

    public LibraryResource(String resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
        this.isAvailable = true;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract int getMaxCheckoutDays();
}

class PhysicalBook extends LibraryResource {
    public PhysicalBook(String resourceId, String title) {
        super(resourceId, title);
    }

    @Override
    public int getMaxCheckoutDays() {
        return 14; // 14 days
    }
}

class EBook extends LibraryResource {
    public EBook(String resourceId, String title) {
        super(resourceId, title);
    }

    @Override
    public int getMaxCheckoutDays() {
        return 7; // 7 days
    }
}

class AudioBook extends LibraryResource {
    public AudioBook(String resourceId, String title) {
        super(resourceId, title);
    }

    @Override
    public int getMaxCheckoutDays() {
        return 10; // 10 days
    }
}

class LibraryUser {
    private final String userId;
    private final String name;
    private final List<LibraryResource> borrowedResources;

    public LibraryUser(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedResources = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean borrowResource(LibraryResource resource) {
        if (!resource.isAvailable()) {
            System.out.println("Resource \"" + resource.getTitle() + "\" is currently unavailable.");
            return false;
        }

        resource.setAvailable(false);
        borrowedResources.add(resource);
        System.out.println(name + " borrowed \"" + resource.getTitle() + "\". Due in " + resource.getMaxCheckoutDays() + " days.");
        return true;
    }

    public void returnResource(LibraryResource resource) {
        if (borrowedResources.remove(resource)) {
            resource.setAvailable(true);
            System.out.println(name + " returned \"" + resource.getTitle() + "\".");
        } else {
            System.out.println(name + " does not have resource \"" + resource.getTitle() + "\" borrowed.");
        }
    }
}