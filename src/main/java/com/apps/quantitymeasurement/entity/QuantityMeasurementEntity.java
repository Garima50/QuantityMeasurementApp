package com.apps.quantitymeasurement.entity;

import java.io.Serializable;
import java.util.Objects;

import com.apps.quantitymeasurement.model.QuantityModel;

public class QuantityMeasurementEntity implements Serializable {

    private QuantityModel<?> thisQuantity;
    private QuantityModel<?> thatQuantity;
    private String operation;

    private QuantityModel<?> quantityResult;
    private Double numericResult;

    private boolean error;
    private String errorMessage;

    // Used for Add / Subtract / Convert
    public QuantityMeasurementEntity(QuantityModel<?> thisQuantity,
                                     QuantityModel<?> thatQuantity,
                                     String operation,
                                     QuantityModel<?> quantityResult) {

        this.thisQuantity = thisQuantity;
        this.thatQuantity = thatQuantity;
        this.operation = operation;
        this.quantityResult = quantityResult;
    }

    // Used for Compare / Divide
    public QuantityMeasurementEntity(QuantityModel<?> thisQuantity,
                                     QuantityModel<?> thatQuantity,
                                     String operation,
                                     Double numericResult) {

        this.thisQuantity = thisQuantity;
        this.thatQuantity = thatQuantity;
        this.operation = operation;
        this.numericResult = numericResult;
    }

    // Used for Error cases
    public QuantityMeasurementEntity(QuantityModel<?> thisQuantity,
                                     QuantityModel<?> thatQuantity,
                                     String operation,
                                     String errorMessage,
                                     boolean error) {

        this.thisQuantity = thisQuantity;
        this.thatQuantity = thatQuantity;
        this.operation = operation;
        this.errorMessage = errorMessage;
        this.error = error;
    }

    public QuantityModel<?> getThisQuantity() {
        return thisQuantity;
    }

    public QuantityModel<?> getThatQuantity() {
        return thatQuantity;
    }

    public String getOperation() {
        return operation;
    }

    public QuantityModel<?> getQuantityResult() {
        return quantityResult;
    }

    public Double getNumericResult() {
        return numericResult;
    }

    public boolean isError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityMeasurementEntity)) return false;

        QuantityMeasurementEntity other = (QuantityMeasurementEntity) obj;

        return Objects.equals(thisQuantity, other.thisQuantity)
                && Objects.equals(thatQuantity, other.thatQuantity)
                && Objects.equals(operation, other.operation)
                && Objects.equals(quantityResult, other.quantityResult)
                && Objects.equals(numericResult, other.numericResult)
                && Objects.equals(errorMessage, other.errorMessage)
                && error == other.error;
    }

    @Override
    public String toString() {

        if (error) {
            return "Operation : " + operation +
                    ", Error : " + errorMessage;
        }

        if (quantityResult != null) {
            return "Operation : " + operation +
                    ", Result : " + quantityResult;
        }

        return "Operation : " + operation +
                ", Result : " + numericResult;
    }
}