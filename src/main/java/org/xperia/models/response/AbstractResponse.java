package org.xperia.models.response;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public abstract class AbstractResponse<T> {

    protected T data;

    protected int status;

    @Override
    public String toString() {
        return "{\n" +
                "\"" + "data" + "\"" + ":" + "\"" + data + "\"" +
                ",\n" +
                "\"status\":" + status + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractResponse<T> that = (AbstractResponse<T>) o;
        return status == that.status && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, status);
    }
}
