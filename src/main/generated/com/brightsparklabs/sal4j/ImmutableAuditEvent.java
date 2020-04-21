package com.brightsparklabs.sal4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link AuditEvent}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAuditEvent.builder()}.
 */
@Generated(from = "AuditEvent", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
final class ImmutableAuditEvent implements AuditEvent {
  private final AuditAction action;
  private final AuditResult result;
  private final String subject;
  private final String object;
  private final String message;
  private final String origin;
  private final Map<String, Object> details;

  private ImmutableAuditEvent(
      AuditAction action,
      AuditResult result,
      String subject,
      String object,
      String message,
      String origin,
      Map<String, Object> details) {
    this.action = action;
    this.result = result;
    this.subject = subject;
    this.object = object;
    this.message = message;
    this.origin = origin;
    this.details = details;
  }

  /**
   * @return The value of the {@code action} attribute
   */
  @JsonProperty("action")
  @Override
  public AuditAction getAction() {
    return action;
  }

  /**
   * @return The value of the {@code result} attribute
   */
  @JsonProperty("result")
  @Override
  public AuditResult getResult() {
    return result;
  }

  /**
   * @return The value of the {@code subject} attribute
   */
  @JsonProperty("subject")
  @Override
  public String getSubject() {
    return subject;
  }

  /**
   * @return The value of the {@code object} attribute
   */
  @JsonProperty("object")
  @Override
  public String getObject() {
    return object;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @JsonProperty("message")
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * @return The value of the {@code origin} attribute
   */
  @JsonProperty("origin")
  @Override
  public String getOrigin() {
    return origin;
  }

  /**
   * @return The value of the {@code details} attribute
   */
  @JsonProperty("details")
  @Override
  public Map<String, Object> getDetails() {
    return details;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuditEvent#getAction() action} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for action
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuditEvent withAction(AuditAction value) {
    if (this.action == value) return this;
    AuditAction newValue = Objects.requireNonNull(value, "action");
    return new ImmutableAuditEvent(newValue, this.result, this.subject, this.object, this.message, this.origin, this.details);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuditEvent#getResult() result} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for result
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuditEvent withResult(AuditResult value) {
    if (this.result == value) return this;
    AuditResult newValue = Objects.requireNonNull(value, "result");
    return new ImmutableAuditEvent(this.action, newValue, this.subject, this.object, this.message, this.origin, this.details);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuditEvent#getSubject() subject} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for subject
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuditEvent withSubject(String value) {
    String newValue = Objects.requireNonNull(value, "subject");
    if (this.subject.equals(newValue)) return this;
    return new ImmutableAuditEvent(this.action, this.result, newValue, this.object, this.message, this.origin, this.details);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuditEvent#getObject() object} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for object
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuditEvent withObject(String value) {
    String newValue = Objects.requireNonNull(value, "object");
    if (this.object.equals(newValue)) return this;
    return new ImmutableAuditEvent(this.action, this.result, this.subject, newValue, this.message, this.origin, this.details);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuditEvent#getMessage() message} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for message
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuditEvent withMessage(String value) {
    String newValue = Objects.requireNonNull(value, "message");
    if (this.message.equals(newValue)) return this;
    return new ImmutableAuditEvent(this.action, this.result, this.subject, this.object, newValue, this.origin, this.details);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuditEvent#getOrigin() origin} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for origin
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuditEvent withOrigin(String value) {
    String newValue = Objects.requireNonNull(value, "origin");
    if (this.origin.equals(newValue)) return this;
    return new ImmutableAuditEvent(this.action, this.result, this.subject, this.object, this.message, newValue, this.details);
  }

  /**
   * Copy the current immutable object by replacing the {@link AuditEvent#getDetails() details} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the details map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAuditEvent withDetails(Map<String, ? extends Object> entries) {
    if (this.details == entries) return this;
    Map<String, Object> newValue = createUnmodifiableMap(true, false, entries);
    return new ImmutableAuditEvent(this.action, this.result, this.subject, this.object, this.message, this.origin, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAuditEvent} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAuditEvent
        && equalTo((ImmutableAuditEvent) another);
  }

  private boolean equalTo(ImmutableAuditEvent another) {
    return action.equals(another.action)
        && result.equals(another.result)
        && subject.equals(another.subject)
        && object.equals(another.object)
        && message.equals(another.message)
        && origin.equals(another.origin)
        && details.equals(another.details);
  }

  /**
   * Computes a hash code from attributes: {@code action}, {@code result}, {@code subject}, {@code object}, {@code message}, {@code origin}, {@code details}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + action.hashCode();
    h += (h << 5) + result.hashCode();
    h += (h << 5) + subject.hashCode();
    h += (h << 5) + object.hashCode();
    h += (h << 5) + message.hashCode();
    h += (h << 5) + origin.hashCode();
    h += (h << 5) + details.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AuditEvent} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "AuditEvent{"
        + "action=" + action
        + ", result=" + result
        + ", subject=" + subject
        + ", object=" + object
        + ", message=" + message
        + ", origin=" + origin
        + ", details=" + details
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link AuditEvent} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AuditEvent instance
   */
  public static ImmutableAuditEvent copyOf(AuditEvent instance) {
    if (instance instanceof ImmutableAuditEvent) {
      return (ImmutableAuditEvent) instance;
    }
    return ImmutableAuditEvent.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAuditEvent ImmutableAuditEvent}.
   * <pre>
   * ImmutableAuditEvent.builder()
   *    .action(com.brightsparklabs.sal4j.AuditAction) // required {@link AuditEvent#getAction() action}
   *    .result(com.brightsparklabs.sal4j.AuditResult) // required {@link AuditEvent#getResult() result}
   *    .subject(String) // required {@link AuditEvent#getSubject() subject}
   *    .object(String) // required {@link AuditEvent#getObject() object}
   *    .message(String) // required {@link AuditEvent#getMessage() message}
   *    .origin(String) // required {@link AuditEvent#getOrigin() origin}
   *    .putDetails|putAllDetails(String =&gt; Object) // {@link AuditEvent#getDetails() details} mappings
   *    .build();
   * </pre>
   * @return A new ImmutableAuditEvent builder
   */
  public static ImmutableAuditEvent.Builder builder() {
    return new ImmutableAuditEvent.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAuditEvent ImmutableAuditEvent}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "AuditEvent", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ACTION = 0x1L;
    private static final long INIT_BIT_RESULT = 0x2L;
    private static final long INIT_BIT_SUBJECT = 0x4L;
    private static final long INIT_BIT_OBJECT = 0x8L;
    private static final long INIT_BIT_MESSAGE = 0x10L;
    private static final long INIT_BIT_ORIGIN = 0x20L;
    private long initBits = 0x3fL;

    private AuditAction action;
    private AuditResult result;
    private String subject;
    private String object;
    private String message;
    private String origin;
    private Map<String, Object> details = new LinkedHashMap<String, Object>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AuditEvent} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AuditEvent instance) {
      Objects.requireNonNull(instance, "instance");
      action(instance.getAction());
      result(instance.getResult());
      subject(instance.getSubject());
      object(instance.getObject());
      message(instance.getMessage());
      origin(instance.getOrigin());
      putAllDetails(instance.getDetails());
      return this;
    }

    /**
     * Initializes the value for the {@link AuditEvent#getAction() action} attribute.
     * @param action The value for action 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("action")
    public final Builder action(AuditAction action) {
      this.action = Objects.requireNonNull(action, "action");
      initBits &= ~INIT_BIT_ACTION;
      return this;
    }

    /**
     * Initializes the value for the {@link AuditEvent#getResult() result} attribute.
     * @param result The value for result 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("result")
    public final Builder result(AuditResult result) {
      this.result = Objects.requireNonNull(result, "result");
      initBits &= ~INIT_BIT_RESULT;
      return this;
    }

    /**
     * Initializes the value for the {@link AuditEvent#getSubject() subject} attribute.
     * @param subject The value for subject 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("subject")
    public final Builder subject(String subject) {
      this.subject = Objects.requireNonNull(subject, "subject");
      initBits &= ~INIT_BIT_SUBJECT;
      return this;
    }

    /**
     * Initializes the value for the {@link AuditEvent#getObject() object} attribute.
     * @param object The value for object 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("object")
    public final Builder object(String object) {
      this.object = Objects.requireNonNull(object, "object");
      initBits &= ~INIT_BIT_OBJECT;
      return this;
    }

    /**
     * Initializes the value for the {@link AuditEvent#getMessage() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("message")
    public final Builder message(String message) {
      this.message = Objects.requireNonNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Initializes the value for the {@link AuditEvent#getOrigin() origin} attribute.
     * @param origin The value for origin 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("origin")
    public final Builder origin(String origin) {
      this.origin = Objects.requireNonNull(origin, "origin");
      initBits &= ~INIT_BIT_ORIGIN;
      return this;
    }

    /**
     * Put one entry to the {@link AuditEvent#getDetails() details} map.
     * @param key The key in the details map
     * @param value The associated value in the details map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putDetails(String key, Object value) {
      this.details.put(
          Objects.requireNonNull(key, "details key"),
          Objects.requireNonNull(value, "details value"));
      return this;
    }

    /**
     * Put one entry to the {@link AuditEvent#getDetails() details} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putDetails(Map.Entry<String, ? extends Object> entry) {
      String k = entry.getKey();
      Object v = entry.getValue();
      this.details.put(
          Objects.requireNonNull(k, "details key"),
          Objects.requireNonNull(v, "details value"));
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link AuditEvent#getDetails() details} map. Nulls are not permitted
     * @param entries The entries that will be added to the details map
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("details")
    public final Builder details(Map<String, ? extends Object> entries) {
      this.details.clear();
      return putAllDetails(entries);
    }

    /**
     * Put all mappings from the specified map as entries to {@link AuditEvent#getDetails() details} map. Nulls are not permitted
     * @param entries The entries that will be added to the details map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllDetails(Map<String, ? extends Object> entries) {
      for (Map.Entry<String, ? extends Object> e : entries.entrySet()) {
        String k = e.getKey();
        Object v = e.getValue();
        this.details.put(
            Objects.requireNonNull(k, "details key"),
            Objects.requireNonNull(v, "details value"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableAuditEvent ImmutableAuditEvent}.
     * @return An immutable instance of AuditEvent
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAuditEvent build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAuditEvent(
          action,
          result,
          subject,
          object,
          message,
          origin,
          createUnmodifiableMap(false, false, details));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ACTION) != 0) attributes.add("action");
      if ((initBits & INIT_BIT_RESULT) != 0) attributes.add("result");
      if ((initBits & INIT_BIT_SUBJECT) != 0) attributes.add("subject");
      if ((initBits & INIT_BIT_OBJECT) != 0) attributes.add("object");
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      if ((initBits & INIT_BIT_ORIGIN) != 0) attributes.add("origin");
      return "Cannot build AuditEvent, some of required attributes are not set " + attributes;
    }
  }

  private static <K, V> Map<K, V> createUnmodifiableMap(boolean checkNulls, boolean skipNulls, Map<? extends K, ? extends V> map) {
    switch (map.size()) {
    case 0: return Collections.emptyMap();
    case 1: {
      Map.Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
      K k = e.getKey();
      V v = e.getValue();
      if (checkNulls) {
        Objects.requireNonNull(k, "key");
        Objects.requireNonNull(v, "value");
      }
      if (skipNulls && (k == null || v == null)) {
        return Collections.emptyMap();
      }
      return Collections.singletonMap(k, v);
    }
    default: {
      Map<K, V> linkedMap = new LinkedHashMap<>(map.size());
      if (skipNulls || checkNulls) {
        for (Map.Entry<? extends K, ? extends V> e : map.entrySet()) {
          K k = e.getKey();
          V v = e.getValue();
          if (skipNulls) {
            if (k == null || v == null) continue;
          } else if (checkNulls) {
            Objects.requireNonNull(k, "key");
            Objects.requireNonNull(v, "value");
          }
          linkedMap.put(k, v);
        }
      } else {
        linkedMap.putAll(map);
      }
      return Collections.unmodifiableMap(linkedMap);
    }
    }
  }
}
