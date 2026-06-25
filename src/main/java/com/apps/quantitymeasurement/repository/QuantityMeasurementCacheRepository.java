package com.apps.quantitymeasurement.repository;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;

/**
 * QuantityMeasurementCacheRepository does the following:
 * 1. Implements the IQuantityMeasurementRepository interface.
 * 2. Maintains an in-memory cache of QuantityMeasurementEntity objects.
 * 3. Provides a Singleton instance of the repository.
 * 4. Saves entities to disk and loads them back on startup.
 * 5. Uses AppendableObjectOutputStream while appending objects.
 */

/**
 * Custom ObjectOutputStream that skips writing a new header
 * when appending objects to an existing file.
 */
class AppendableObjectOutputStream extends ObjectOutputStream {

    public AppendableObjectOutputStream(OutputStream out)
            throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {

        File file =
                new File(QuantityMeasurementCacheRepository.FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            super.writeStreamHeader();
        } else {
            reset();
        }
    }
}

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    // File used to store serialized entities
    public static final String FILE_NAME =
            "quantity_measurement_repo.ser";

    // In-memory cache
    private List<QuantityMeasurementEntity>
            quantityMeasurementEntityCache;

    // Singleton instance
    private static QuantityMeasurementCacheRepository instance;

    // Private constructor
    private QuantityMeasurementCacheRepository() {

        quantityMeasurementEntityCache = new ArrayList<>();

        loadFromDisk();
    }

    /**
     * Returns the singleton repository instance.
     */
    public static QuantityMeasurementCacheRepository getInstance() {

        if (instance == null) {
            instance = new QuantityMeasurementCacheRepository();
        }

        return instance;
    }

        /**
     * Saves a quantity measurement entity to the cache and persists it.
     *
     * @param entity quantity measurement entity to be saved
     */
    @Override
    public void save(
            QuantityMeasurementEntity entity
    ) {

        if (entity == null) {

            throw new IllegalArgumentException(
                    "Entity cannot be null"
            );
        }

        quantityMeasurementEntityCache.add(
                entity
        );

        saveToDisk(
                entity
        );
    }

    /**
     * Returns all quantity measurement entities stored in the cache.
     *
     * @return list of quantity measurement entities
     */
    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {

        return new ArrayList<>(
                quantityMeasurementEntityCache
        );
    }

        /**
     * Saves a quantity measurement entity to disk.
     *
     * @param entity quantity measurement entity to save
     */
    private void saveToDisk(
            QuantityMeasurementEntity entity
    ) {

        File file =
                new File(
                        FILE_NAME
                );

        boolean append =
                file.exists()
                && file.length() > 0;

        try (
                FileOutputStream fileOutputStream =
                        new FileOutputStream(
                                file,
                                true
                        );

                ObjectOutputStream objectOutputStream =
                        append
                                ? new AppendableObjectOutputStream(
                                        fileOutputStream
                                )
                                : new ObjectOutputStream(
                                        fileOutputStream
                                )
        ) {

            objectOutputStream.writeObject(
                    entity
            );

            objectOutputStream.flush();

        }
        catch (
                IOException exception
        ) {

            throw new RuntimeException(
                    "Failed to save entity to disk.",
                    exception
            );
        }
    }

        /**
     * Loads all quantity measurement entities from disk into memory.
     */
    
    private void loadFromDisk() {

        File file =
                new File(
                        FILE_NAME
                );

        if (!file.exists()) {
            return;
        }

        try (
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(
                                new FileInputStream(
                                        file
                                )
                        )
        ) {

            while (true) {

                QuantityMeasurementEntity entity =
                        (QuantityMeasurementEntity)
                                objectInputStream.readObject();

                quantityMeasurementEntityCache.add(
                        entity
                );
            }

        }
        catch (
                EOFException exception
        ) {

            System.out.println(
                    "Loaded "
                    + quantityMeasurementEntityCache.size()
                    + " quantity measurement entities from storage."
            );
        }
        catch (
                IOException
                | ClassNotFoundException exception
        ) {

            throw new RuntimeException(
                    "Failed to load repository data.",
                    exception
            );
        }
    }

    /**
     * Main method for testing repository operations.
     */
    public static void main(
            String[] args
    ) {

        QuantityMeasurementCacheRepository repository =
                QuantityMeasurementCacheRepository
                        .getInstance();

        System.out.println(
                "Stored Entities : "
                + repository
                        .getAllMeasurements()
                        .size()
        );
    }


}