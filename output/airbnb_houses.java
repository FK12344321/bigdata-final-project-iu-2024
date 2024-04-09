// ORM class for table 'airbnb_houses'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Apr 09 21:50:24 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class airbnb_houses extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.id = (Integer)value;
      }
    });
    setters.put("log_price", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.log_price = (java.math.BigDecimal)value;
      }
    });
    setters.put("property_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.property_type = (String)value;
      }
    });
    setters.put("room_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.room_type = (String)value;
      }
    });
    setters.put("amenities", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.amenities = (String)value;
      }
    });
    setters.put("accommodates", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.accommodates = (Integer)value;
      }
    });
    setters.put("bathrooms", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.bathrooms = (java.math.BigDecimal)value;
      }
    });
    setters.put("bed_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.bed_type = (String)value;
      }
    });
    setters.put("cancellation_policy", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.cancellation_policy = (String)value;
      }
    });
    setters.put("cleaning_fee", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.cleaning_fee = (Boolean)value;
      }
    });
    setters.put("city", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.city = (String)value;
      }
    });
    setters.put("description", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.description = (String)value;
      }
    });
    setters.put("first_review", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.first_review = (java.sql.Date)value;
      }
    });
    setters.put("host_has_profile_pic", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.host_has_profile_pic = (Boolean)value;
      }
    });
    setters.put("host_identity_verified", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.host_identity_verified = (Boolean)value;
      }
    });
    setters.put("host_response_rate", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.host_response_rate = (String)value;
      }
    });
    setters.put("host_since", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.host_since = (java.sql.Date)value;
      }
    });
    setters.put("instant_bookable", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.instant_bookable = (Boolean)value;
      }
    });
    setters.put("last_review", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.last_review = (java.sql.Date)value;
      }
    });
    setters.put("latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.latitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.longitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.name = (String)value;
      }
    });
    setters.put("neighbourhood", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.neighbourhood = (String)value;
      }
    });
    setters.put("number_of_reviews", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.number_of_reviews = (Integer)value;
      }
    });
    setters.put("review_scores_rating", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.review_scores_rating = (java.math.BigDecimal)value;
      }
    });
    setters.put("thumbnail_url", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.thumbnail_url = (String)value;
      }
    });
    setters.put("zipcode", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.zipcode = (String)value;
      }
    });
    setters.put("bedrooms", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.bedrooms = (java.math.BigDecimal)value;
      }
    });
    setters.put("beds", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        airbnb_houses.this.beds = (java.math.BigDecimal)value;
      }
    });
  }
  public airbnb_houses() {
    init0();
  }
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public airbnb_houses with_id(Integer id) {
    this.id = id;
    return this;
  }
  private java.math.BigDecimal log_price;
  public java.math.BigDecimal get_log_price() {
    return log_price;
  }
  public void set_log_price(java.math.BigDecimal log_price) {
    this.log_price = log_price;
  }
  public airbnb_houses with_log_price(java.math.BigDecimal log_price) {
    this.log_price = log_price;
    return this;
  }
  private String property_type;
  public String get_property_type() {
    return property_type;
  }
  public void set_property_type(String property_type) {
    this.property_type = property_type;
  }
  public airbnb_houses with_property_type(String property_type) {
    this.property_type = property_type;
    return this;
  }
  private String room_type;
  public String get_room_type() {
    return room_type;
  }
  public void set_room_type(String room_type) {
    this.room_type = room_type;
  }
  public airbnb_houses with_room_type(String room_type) {
    this.room_type = room_type;
    return this;
  }
  private String amenities;
  public String get_amenities() {
    return amenities;
  }
  public void set_amenities(String amenities) {
    this.amenities = amenities;
  }
  public airbnb_houses with_amenities(String amenities) {
    this.amenities = amenities;
    return this;
  }
  private Integer accommodates;
  public Integer get_accommodates() {
    return accommodates;
  }
  public void set_accommodates(Integer accommodates) {
    this.accommodates = accommodates;
  }
  public airbnb_houses with_accommodates(Integer accommodates) {
    this.accommodates = accommodates;
    return this;
  }
  private java.math.BigDecimal bathrooms;
  public java.math.BigDecimal get_bathrooms() {
    return bathrooms;
  }
  public void set_bathrooms(java.math.BigDecimal bathrooms) {
    this.bathrooms = bathrooms;
  }
  public airbnb_houses with_bathrooms(java.math.BigDecimal bathrooms) {
    this.bathrooms = bathrooms;
    return this;
  }
  private String bed_type;
  public String get_bed_type() {
    return bed_type;
  }
  public void set_bed_type(String bed_type) {
    this.bed_type = bed_type;
  }
  public airbnb_houses with_bed_type(String bed_type) {
    this.bed_type = bed_type;
    return this;
  }
  private String cancellation_policy;
  public String get_cancellation_policy() {
    return cancellation_policy;
  }
  public void set_cancellation_policy(String cancellation_policy) {
    this.cancellation_policy = cancellation_policy;
  }
  public airbnb_houses with_cancellation_policy(String cancellation_policy) {
    this.cancellation_policy = cancellation_policy;
    return this;
  }
  private Boolean cleaning_fee;
  public Boolean get_cleaning_fee() {
    return cleaning_fee;
  }
  public void set_cleaning_fee(Boolean cleaning_fee) {
    this.cleaning_fee = cleaning_fee;
  }
  public airbnb_houses with_cleaning_fee(Boolean cleaning_fee) {
    this.cleaning_fee = cleaning_fee;
    return this;
  }
  private String city;
  public String get_city() {
    return city;
  }
  public void set_city(String city) {
    this.city = city;
  }
  public airbnb_houses with_city(String city) {
    this.city = city;
    return this;
  }
  private String description;
  public String get_description() {
    return description;
  }
  public void set_description(String description) {
    this.description = description;
  }
  public airbnb_houses with_description(String description) {
    this.description = description;
    return this;
  }
  private java.sql.Date first_review;
  public java.sql.Date get_first_review() {
    return first_review;
  }
  public void set_first_review(java.sql.Date first_review) {
    this.first_review = first_review;
  }
  public airbnb_houses with_first_review(java.sql.Date first_review) {
    this.first_review = first_review;
    return this;
  }
  private Boolean host_has_profile_pic;
  public Boolean get_host_has_profile_pic() {
    return host_has_profile_pic;
  }
  public void set_host_has_profile_pic(Boolean host_has_profile_pic) {
    this.host_has_profile_pic = host_has_profile_pic;
  }
  public airbnb_houses with_host_has_profile_pic(Boolean host_has_profile_pic) {
    this.host_has_profile_pic = host_has_profile_pic;
    return this;
  }
  private Boolean host_identity_verified;
  public Boolean get_host_identity_verified() {
    return host_identity_verified;
  }
  public void set_host_identity_verified(Boolean host_identity_verified) {
    this.host_identity_verified = host_identity_verified;
  }
  public airbnb_houses with_host_identity_verified(Boolean host_identity_verified) {
    this.host_identity_verified = host_identity_verified;
    return this;
  }
  private String host_response_rate;
  public String get_host_response_rate() {
    return host_response_rate;
  }
  public void set_host_response_rate(String host_response_rate) {
    this.host_response_rate = host_response_rate;
  }
  public airbnb_houses with_host_response_rate(String host_response_rate) {
    this.host_response_rate = host_response_rate;
    return this;
  }
  private java.sql.Date host_since;
  public java.sql.Date get_host_since() {
    return host_since;
  }
  public void set_host_since(java.sql.Date host_since) {
    this.host_since = host_since;
  }
  public airbnb_houses with_host_since(java.sql.Date host_since) {
    this.host_since = host_since;
    return this;
  }
  private Boolean instant_bookable;
  public Boolean get_instant_bookable() {
    return instant_bookable;
  }
  public void set_instant_bookable(Boolean instant_bookable) {
    this.instant_bookable = instant_bookable;
  }
  public airbnb_houses with_instant_bookable(Boolean instant_bookable) {
    this.instant_bookable = instant_bookable;
    return this;
  }
  private java.sql.Date last_review;
  public java.sql.Date get_last_review() {
    return last_review;
  }
  public void set_last_review(java.sql.Date last_review) {
    this.last_review = last_review;
  }
  public airbnb_houses with_last_review(java.sql.Date last_review) {
    this.last_review = last_review;
    return this;
  }
  private java.math.BigDecimal latitude;
  public java.math.BigDecimal get_latitude() {
    return latitude;
  }
  public void set_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
  }
  public airbnb_houses with_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
    return this;
  }
  private java.math.BigDecimal longitude;
  public java.math.BigDecimal get_longitude() {
    return longitude;
  }
  public void set_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
  }
  public airbnb_houses with_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
    return this;
  }
  private String name;
  public String get_name() {
    return name;
  }
  public void set_name(String name) {
    this.name = name;
  }
  public airbnb_houses with_name(String name) {
    this.name = name;
    return this;
  }
  private String neighbourhood;
  public String get_neighbourhood() {
    return neighbourhood;
  }
  public void set_neighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
  }
  public airbnb_houses with_neighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
    return this;
  }
  private Integer number_of_reviews;
  public Integer get_number_of_reviews() {
    return number_of_reviews;
  }
  public void set_number_of_reviews(Integer number_of_reviews) {
    this.number_of_reviews = number_of_reviews;
  }
  public airbnb_houses with_number_of_reviews(Integer number_of_reviews) {
    this.number_of_reviews = number_of_reviews;
    return this;
  }
  private java.math.BigDecimal review_scores_rating;
  public java.math.BigDecimal get_review_scores_rating() {
    return review_scores_rating;
  }
  public void set_review_scores_rating(java.math.BigDecimal review_scores_rating) {
    this.review_scores_rating = review_scores_rating;
  }
  public airbnb_houses with_review_scores_rating(java.math.BigDecimal review_scores_rating) {
    this.review_scores_rating = review_scores_rating;
    return this;
  }
  private String thumbnail_url;
  public String get_thumbnail_url() {
    return thumbnail_url;
  }
  public void set_thumbnail_url(String thumbnail_url) {
    this.thumbnail_url = thumbnail_url;
  }
  public airbnb_houses with_thumbnail_url(String thumbnail_url) {
    this.thumbnail_url = thumbnail_url;
    return this;
  }
  private String zipcode;
  public String get_zipcode() {
    return zipcode;
  }
  public void set_zipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public airbnb_houses with_zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }
  private java.math.BigDecimal bedrooms;
  public java.math.BigDecimal get_bedrooms() {
    return bedrooms;
  }
  public void set_bedrooms(java.math.BigDecimal bedrooms) {
    this.bedrooms = bedrooms;
  }
  public airbnb_houses with_bedrooms(java.math.BigDecimal bedrooms) {
    this.bedrooms = bedrooms;
    return this;
  }
  private java.math.BigDecimal beds;
  public java.math.BigDecimal get_beds() {
    return beds;
  }
  public void set_beds(java.math.BigDecimal beds) {
    this.beds = beds;
  }
  public airbnb_houses with_beds(java.math.BigDecimal beds) {
    this.beds = beds;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof airbnb_houses)) {
      return false;
    }
    airbnb_houses that = (airbnb_houses) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.log_price == null ? that.log_price == null : this.log_price.equals(that.log_price));
    equal = equal && (this.property_type == null ? that.property_type == null : this.property_type.equals(that.property_type));
    equal = equal && (this.room_type == null ? that.room_type == null : this.room_type.equals(that.room_type));
    equal = equal && (this.amenities == null ? that.amenities == null : this.amenities.equals(that.amenities));
    equal = equal && (this.accommodates == null ? that.accommodates == null : this.accommodates.equals(that.accommodates));
    equal = equal && (this.bathrooms == null ? that.bathrooms == null : this.bathrooms.equals(that.bathrooms));
    equal = equal && (this.bed_type == null ? that.bed_type == null : this.bed_type.equals(that.bed_type));
    equal = equal && (this.cancellation_policy == null ? that.cancellation_policy == null : this.cancellation_policy.equals(that.cancellation_policy));
    equal = equal && (this.cleaning_fee == null ? that.cleaning_fee == null : this.cleaning_fee.equals(that.cleaning_fee));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.description == null ? that.description == null : this.description.equals(that.description));
    equal = equal && (this.first_review == null ? that.first_review == null : this.first_review.equals(that.first_review));
    equal = equal && (this.host_has_profile_pic == null ? that.host_has_profile_pic == null : this.host_has_profile_pic.equals(that.host_has_profile_pic));
    equal = equal && (this.host_identity_verified == null ? that.host_identity_verified == null : this.host_identity_verified.equals(that.host_identity_verified));
    equal = equal && (this.host_response_rate == null ? that.host_response_rate == null : this.host_response_rate.equals(that.host_response_rate));
    equal = equal && (this.host_since == null ? that.host_since == null : this.host_since.equals(that.host_since));
    equal = equal && (this.instant_bookable == null ? that.instant_bookable == null : this.instant_bookable.equals(that.instant_bookable));
    equal = equal && (this.last_review == null ? that.last_review == null : this.last_review.equals(that.last_review));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.name == null ? that.name == null : this.name.equals(that.name));
    equal = equal && (this.neighbourhood == null ? that.neighbourhood == null : this.neighbourhood.equals(that.neighbourhood));
    equal = equal && (this.number_of_reviews == null ? that.number_of_reviews == null : this.number_of_reviews.equals(that.number_of_reviews));
    equal = equal && (this.review_scores_rating == null ? that.review_scores_rating == null : this.review_scores_rating.equals(that.review_scores_rating));
    equal = equal && (this.thumbnail_url == null ? that.thumbnail_url == null : this.thumbnail_url.equals(that.thumbnail_url));
    equal = equal && (this.zipcode == null ? that.zipcode == null : this.zipcode.equals(that.zipcode));
    equal = equal && (this.bedrooms == null ? that.bedrooms == null : this.bedrooms.equals(that.bedrooms));
    equal = equal && (this.beds == null ? that.beds == null : this.beds.equals(that.beds));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof airbnb_houses)) {
      return false;
    }
    airbnb_houses that = (airbnb_houses) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.log_price == null ? that.log_price == null : this.log_price.equals(that.log_price));
    equal = equal && (this.property_type == null ? that.property_type == null : this.property_type.equals(that.property_type));
    equal = equal && (this.room_type == null ? that.room_type == null : this.room_type.equals(that.room_type));
    equal = equal && (this.amenities == null ? that.amenities == null : this.amenities.equals(that.amenities));
    equal = equal && (this.accommodates == null ? that.accommodates == null : this.accommodates.equals(that.accommodates));
    equal = equal && (this.bathrooms == null ? that.bathrooms == null : this.bathrooms.equals(that.bathrooms));
    equal = equal && (this.bed_type == null ? that.bed_type == null : this.bed_type.equals(that.bed_type));
    equal = equal && (this.cancellation_policy == null ? that.cancellation_policy == null : this.cancellation_policy.equals(that.cancellation_policy));
    equal = equal && (this.cleaning_fee == null ? that.cleaning_fee == null : this.cleaning_fee.equals(that.cleaning_fee));
    equal = equal && (this.city == null ? that.city == null : this.city.equals(that.city));
    equal = equal && (this.description == null ? that.description == null : this.description.equals(that.description));
    equal = equal && (this.first_review == null ? that.first_review == null : this.first_review.equals(that.first_review));
    equal = equal && (this.host_has_profile_pic == null ? that.host_has_profile_pic == null : this.host_has_profile_pic.equals(that.host_has_profile_pic));
    equal = equal && (this.host_identity_verified == null ? that.host_identity_verified == null : this.host_identity_verified.equals(that.host_identity_verified));
    equal = equal && (this.host_response_rate == null ? that.host_response_rate == null : this.host_response_rate.equals(that.host_response_rate));
    equal = equal && (this.host_since == null ? that.host_since == null : this.host_since.equals(that.host_since));
    equal = equal && (this.instant_bookable == null ? that.instant_bookable == null : this.instant_bookable.equals(that.instant_bookable));
    equal = equal && (this.last_review == null ? that.last_review == null : this.last_review.equals(that.last_review));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.name == null ? that.name == null : this.name.equals(that.name));
    equal = equal && (this.neighbourhood == null ? that.neighbourhood == null : this.neighbourhood.equals(that.neighbourhood));
    equal = equal && (this.number_of_reviews == null ? that.number_of_reviews == null : this.number_of_reviews.equals(that.number_of_reviews));
    equal = equal && (this.review_scores_rating == null ? that.review_scores_rating == null : this.review_scores_rating.equals(that.review_scores_rating));
    equal = equal && (this.thumbnail_url == null ? that.thumbnail_url == null : this.thumbnail_url.equals(that.thumbnail_url));
    equal = equal && (this.zipcode == null ? that.zipcode == null : this.zipcode.equals(that.zipcode));
    equal = equal && (this.bedrooms == null ? that.bedrooms == null : this.bedrooms.equals(that.bedrooms));
    equal = equal && (this.beds == null ? that.beds == null : this.beds.equals(that.beds));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.log_price = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.property_type = JdbcWritableBridge.readString(3, __dbResults);
    this.room_type = JdbcWritableBridge.readString(4, __dbResults);
    this.amenities = JdbcWritableBridge.readString(5, __dbResults);
    this.accommodates = JdbcWritableBridge.readInteger(6, __dbResults);
    this.bathrooms = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.bed_type = JdbcWritableBridge.readString(8, __dbResults);
    this.cancellation_policy = JdbcWritableBridge.readString(9, __dbResults);
    this.cleaning_fee = JdbcWritableBridge.readBoolean(10, __dbResults);
    this.city = JdbcWritableBridge.readString(11, __dbResults);
    this.description = JdbcWritableBridge.readString(12, __dbResults);
    this.first_review = JdbcWritableBridge.readDate(13, __dbResults);
    this.host_has_profile_pic = JdbcWritableBridge.readBoolean(14, __dbResults);
    this.host_identity_verified = JdbcWritableBridge.readBoolean(15, __dbResults);
    this.host_response_rate = JdbcWritableBridge.readString(16, __dbResults);
    this.host_since = JdbcWritableBridge.readDate(17, __dbResults);
    this.instant_bookable = JdbcWritableBridge.readBoolean(18, __dbResults);
    this.last_review = JdbcWritableBridge.readDate(19, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(21, __dbResults);
    this.name = JdbcWritableBridge.readString(22, __dbResults);
    this.neighbourhood = JdbcWritableBridge.readString(23, __dbResults);
    this.number_of_reviews = JdbcWritableBridge.readInteger(24, __dbResults);
    this.review_scores_rating = JdbcWritableBridge.readBigDecimal(25, __dbResults);
    this.thumbnail_url = JdbcWritableBridge.readString(26, __dbResults);
    this.zipcode = JdbcWritableBridge.readString(27, __dbResults);
    this.bedrooms = JdbcWritableBridge.readBigDecimal(28, __dbResults);
    this.beds = JdbcWritableBridge.readBigDecimal(29, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.log_price = JdbcWritableBridge.readBigDecimal(2, __dbResults);
    this.property_type = JdbcWritableBridge.readString(3, __dbResults);
    this.room_type = JdbcWritableBridge.readString(4, __dbResults);
    this.amenities = JdbcWritableBridge.readString(5, __dbResults);
    this.accommodates = JdbcWritableBridge.readInteger(6, __dbResults);
    this.bathrooms = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.bed_type = JdbcWritableBridge.readString(8, __dbResults);
    this.cancellation_policy = JdbcWritableBridge.readString(9, __dbResults);
    this.cleaning_fee = JdbcWritableBridge.readBoolean(10, __dbResults);
    this.city = JdbcWritableBridge.readString(11, __dbResults);
    this.description = JdbcWritableBridge.readString(12, __dbResults);
    this.first_review = JdbcWritableBridge.readDate(13, __dbResults);
    this.host_has_profile_pic = JdbcWritableBridge.readBoolean(14, __dbResults);
    this.host_identity_verified = JdbcWritableBridge.readBoolean(15, __dbResults);
    this.host_response_rate = JdbcWritableBridge.readString(16, __dbResults);
    this.host_since = JdbcWritableBridge.readDate(17, __dbResults);
    this.instant_bookable = JdbcWritableBridge.readBoolean(18, __dbResults);
    this.last_review = JdbcWritableBridge.readDate(19, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(21, __dbResults);
    this.name = JdbcWritableBridge.readString(22, __dbResults);
    this.neighbourhood = JdbcWritableBridge.readString(23, __dbResults);
    this.number_of_reviews = JdbcWritableBridge.readInteger(24, __dbResults);
    this.review_scores_rating = JdbcWritableBridge.readBigDecimal(25, __dbResults);
    this.thumbnail_url = JdbcWritableBridge.readString(26, __dbResults);
    this.zipcode = JdbcWritableBridge.readString(27, __dbResults);
    this.bedrooms = JdbcWritableBridge.readBigDecimal(28, __dbResults);
    this.beds = JdbcWritableBridge.readBigDecimal(29, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(log_price, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(property_type, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(room_type, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(amenities, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(accommodates, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(bathrooms, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(bed_type, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(cancellation_policy, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(cleaning_fee, 10 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(city, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(description, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDate(first_review, 13 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeBoolean(host_has_profile_pic, 14 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(host_identity_verified, 15 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(host_response_rate, 16 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDate(host_since, 17 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeBoolean(instant_bookable, 18 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeDate(last_review, 19 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 20 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 21 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(name, 22 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(neighbourhood, 23 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(number_of_reviews, 24 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(review_scores_rating, 25 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(thumbnail_url, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zipcode, 27 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(bedrooms, 28 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(beds, 29 + __off, 2, __dbStmt);
    return 29;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(log_price, 2 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(property_type, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(room_type, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(amenities, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(accommodates, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(bathrooms, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(bed_type, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(cancellation_policy, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(cleaning_fee, 10 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(city, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(description, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDate(first_review, 13 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeBoolean(host_has_profile_pic, 14 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(host_identity_verified, 15 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(host_response_rate, 16 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDate(host_since, 17 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeBoolean(instant_bookable, 18 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeDate(last_review, 19 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 20 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 21 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(name, 22 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(neighbourhood, 23 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(number_of_reviews, 24 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(review_scores_rating, 25 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeString(thumbnail_url, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(zipcode, 27 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(bedrooms, 28 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(beds, 29 + __off, 2, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.log_price = null;
    } else {
    this.log_price = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.property_type = null;
    } else {
    this.property_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.room_type = null;
    } else {
    this.room_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.amenities = null;
    } else {
    this.amenities = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.accommodates = null;
    } else {
    this.accommodates = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.bathrooms = null;
    } else {
    this.bathrooms = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.bed_type = null;
    } else {
    this.bed_type = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.cancellation_policy = null;
    } else {
    this.cancellation_policy = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.cleaning_fee = null;
    } else {
    this.cleaning_fee = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.city = null;
    } else {
    this.city = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.description = null;
    } else {
    this.description = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.first_review = null;
    } else {
    this.first_review = new Date(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.host_has_profile_pic = null;
    } else {
    this.host_has_profile_pic = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.host_identity_verified = null;
    } else {
    this.host_identity_verified = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.host_response_rate = null;
    } else {
    this.host_response_rate = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.host_since = null;
    } else {
    this.host_since = new Date(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.instant_bookable = null;
    } else {
    this.instant_bookable = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.last_review = null;
    } else {
    this.last_review = new Date(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.latitude = null;
    } else {
    this.latitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.longitude = null;
    } else {
    this.longitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.name = null;
    } else {
    this.name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.neighbourhood = null;
    } else {
    this.neighbourhood = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.number_of_reviews = null;
    } else {
    this.number_of_reviews = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.review_scores_rating = null;
    } else {
    this.review_scores_rating = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.thumbnail_url = null;
    } else {
    this.thumbnail_url = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.zipcode = null;
    } else {
    this.zipcode = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.bedrooms = null;
    } else {
    this.bedrooms = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.beds = null;
    } else {
    this.beds = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.log_price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.log_price, __dataOut);
    }
    if (null == this.property_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, property_type);
    }
    if (null == this.room_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, room_type);
    }
    if (null == this.amenities) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, amenities);
    }
    if (null == this.accommodates) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.accommodates);
    }
    if (null == this.bathrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.bathrooms, __dataOut);
    }
    if (null == this.bed_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, bed_type);
    }
    if (null == this.cancellation_policy) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, cancellation_policy);
    }
    if (null == this.cleaning_fee) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.cleaning_fee);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, description);
    }
    if (null == this.first_review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.first_review.getTime());
    }
    if (null == this.host_has_profile_pic) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.host_has_profile_pic);
    }
    if (null == this.host_identity_verified) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.host_identity_verified);
    }
    if (null == this.host_response_rate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, host_response_rate);
    }
    if (null == this.host_since) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.host_since.getTime());
    }
    if (null == this.instant_bookable) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.instant_bookable);
    }
    if (null == this.last_review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.last_review.getTime());
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
    if (null == this.name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, name);
    }
    if (null == this.neighbourhood) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, neighbourhood);
    }
    if (null == this.number_of_reviews) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.number_of_reviews);
    }
    if (null == this.review_scores_rating) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.review_scores_rating, __dataOut);
    }
    if (null == this.thumbnail_url) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, thumbnail_url);
    }
    if (null == this.zipcode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zipcode);
    }
    if (null == this.bedrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.bedrooms, __dataOut);
    }
    if (null == this.beds) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.beds, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.log_price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.log_price, __dataOut);
    }
    if (null == this.property_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, property_type);
    }
    if (null == this.room_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, room_type);
    }
    if (null == this.amenities) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, amenities);
    }
    if (null == this.accommodates) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.accommodates);
    }
    if (null == this.bathrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.bathrooms, __dataOut);
    }
    if (null == this.bed_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, bed_type);
    }
    if (null == this.cancellation_policy) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, cancellation_policy);
    }
    if (null == this.cleaning_fee) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.cleaning_fee);
    }
    if (null == this.city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, city);
    }
    if (null == this.description) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, description);
    }
    if (null == this.first_review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.first_review.getTime());
    }
    if (null == this.host_has_profile_pic) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.host_has_profile_pic);
    }
    if (null == this.host_identity_verified) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.host_identity_verified);
    }
    if (null == this.host_response_rate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, host_response_rate);
    }
    if (null == this.host_since) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.host_since.getTime());
    }
    if (null == this.instant_bookable) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.instant_bookable);
    }
    if (null == this.last_review) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.last_review.getTime());
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
    if (null == this.name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, name);
    }
    if (null == this.neighbourhood) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, neighbourhood);
    }
    if (null == this.number_of_reviews) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.number_of_reviews);
    }
    if (null == this.review_scores_rating) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.review_scores_rating, __dataOut);
    }
    if (null == this.thumbnail_url) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, thumbnail_url);
    }
    if (null == this.zipcode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, zipcode);
    }
    if (null == this.bedrooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.bedrooms, __dataOut);
    }
    if (null == this.beds) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.beds, __dataOut);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(log_price==null?"null":log_price.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(property_type==null?"null":property_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(room_type==null?"null":room_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(amenities==null?"null":amenities, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(accommodates==null?"null":"" + accommodates, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bathrooms==null?"null":bathrooms.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bed_type==null?"null":bed_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cancellation_policy==null?"null":cancellation_policy, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cleaning_fee==null?"null":"" + cleaning_fee, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(description==null?"null":description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(first_review==null?"null":"" + first_review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_has_profile_pic==null?"null":"" + host_has_profile_pic, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_identity_verified==null?"null":"" + host_identity_verified, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_response_rate==null?"null":host_response_rate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_since==null?"null":"" + host_since, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(instant_bookable==null?"null":"" + instant_bookable, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_review==null?"null":"" + last_review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(name==null?"null":name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(neighbourhood==null?"null":neighbourhood, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_reviews==null?"null":"" + number_of_reviews, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_rating==null?"null":review_scores_rating.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(thumbnail_url==null?"null":thumbnail_url, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zipcode==null?"null":zipcode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bedrooms==null?"null":bedrooms.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(beds==null?"null":beds.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(log_price==null?"null":log_price.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(property_type==null?"null":property_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(room_type==null?"null":room_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(amenities==null?"null":amenities, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(accommodates==null?"null":"" + accommodates, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bathrooms==null?"null":bathrooms.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bed_type==null?"null":bed_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cancellation_policy==null?"null":cancellation_policy, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cleaning_fee==null?"null":"" + cleaning_fee, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(city==null?"null":city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(description==null?"null":description, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(first_review==null?"null":"" + first_review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_has_profile_pic==null?"null":"" + host_has_profile_pic, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_identity_verified==null?"null":"" + host_identity_verified, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_response_rate==null?"null":host_response_rate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host_since==null?"null":"" + host_since, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(instant_bookable==null?"null":"" + instant_bookable, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_review==null?"null":"" + last_review, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(name==null?"null":name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(neighbourhood==null?"null":neighbourhood, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_reviews==null?"null":"" + number_of_reviews, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(review_scores_rating==null?"null":review_scores_rating.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(thumbnail_url==null?"null":thumbnail_url, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(zipcode==null?"null":zipcode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bedrooms==null?"null":bedrooms.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(beds==null?"null":beds.toPlainString(), delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.log_price = null; } else {
      this.log_price = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.property_type = null; } else {
      this.property_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.room_type = null; } else {
      this.room_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.amenities = null; } else {
      this.amenities = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.accommodates = null; } else {
      this.accommodates = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bathrooms = null; } else {
      this.bathrooms = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.bed_type = null; } else {
      this.bed_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.cancellation_policy = null; } else {
      this.cancellation_policy = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cleaning_fee = null; } else {
      this.cleaning_fee = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.description = null; } else {
      this.description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.first_review = null; } else {
      this.first_review = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.host_has_profile_pic = null; } else {
      this.host_has_profile_pic = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.host_identity_verified = null; } else {
      this.host_identity_verified = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.host_response_rate = null; } else {
      this.host_response_rate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.host_since = null; } else {
      this.host_since = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.instant_bookable = null; } else {
      this.instant_bookable = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.last_review = null; } else {
      this.last_review = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.name = null; } else {
      this.name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.neighbourhood = null; } else {
      this.neighbourhood = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_reviews = null; } else {
      this.number_of_reviews = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_rating = null; } else {
      this.review_scores_rating = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.thumbnail_url = null; } else {
      this.thumbnail_url = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zipcode = null; } else {
      this.zipcode = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bedrooms = null; } else {
      this.bedrooms = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.beds = null; } else {
      this.beds = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.log_price = null; } else {
      this.log_price = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.property_type = null; } else {
      this.property_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.room_type = null; } else {
      this.room_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.amenities = null; } else {
      this.amenities = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.accommodates = null; } else {
      this.accommodates = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bathrooms = null; } else {
      this.bathrooms = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.bed_type = null; } else {
      this.bed_type = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.cancellation_policy = null; } else {
      this.cancellation_policy = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cleaning_fee = null; } else {
      this.cleaning_fee = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.city = null; } else {
      this.city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.description = null; } else {
      this.description = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.first_review = null; } else {
      this.first_review = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.host_has_profile_pic = null; } else {
      this.host_has_profile_pic = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.host_identity_verified = null; } else {
      this.host_identity_verified = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.host_response_rate = null; } else {
      this.host_response_rate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.host_since = null; } else {
      this.host_since = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.instant_bookable = null; } else {
      this.instant_bookable = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.last_review = null; } else {
      this.last_review = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.name = null; } else {
      this.name = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.neighbourhood = null; } else {
      this.neighbourhood = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_reviews = null; } else {
      this.number_of_reviews = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.review_scores_rating = null; } else {
      this.review_scores_rating = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.thumbnail_url = null; } else {
      this.thumbnail_url = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.zipcode = null; } else {
      this.zipcode = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bedrooms = null; } else {
      this.bedrooms = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.beds = null; } else {
      this.beds = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    airbnb_houses o = (airbnb_houses) super.clone();
    o.first_review = (o.first_review != null) ? (java.sql.Date) o.first_review.clone() : null;
    o.host_since = (o.host_since != null) ? (java.sql.Date) o.host_since.clone() : null;
    o.last_review = (o.last_review != null) ? (java.sql.Date) o.last_review.clone() : null;
    return o;
  }

  public void clone0(airbnb_houses o) throws CloneNotSupportedException {
    o.first_review = (o.first_review != null) ? (java.sql.Date) o.first_review.clone() : null;
    o.host_since = (o.host_since != null) ? (java.sql.Date) o.host_since.clone() : null;
    o.last_review = (o.last_review != null) ? (java.sql.Date) o.last_review.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("log_price", this.log_price);
    __sqoop$field_map.put("property_type", this.property_type);
    __sqoop$field_map.put("room_type", this.room_type);
    __sqoop$field_map.put("amenities", this.amenities);
    __sqoop$field_map.put("accommodates", this.accommodates);
    __sqoop$field_map.put("bathrooms", this.bathrooms);
    __sqoop$field_map.put("bed_type", this.bed_type);
    __sqoop$field_map.put("cancellation_policy", this.cancellation_policy);
    __sqoop$field_map.put("cleaning_fee", this.cleaning_fee);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("description", this.description);
    __sqoop$field_map.put("first_review", this.first_review);
    __sqoop$field_map.put("host_has_profile_pic", this.host_has_profile_pic);
    __sqoop$field_map.put("host_identity_verified", this.host_identity_verified);
    __sqoop$field_map.put("host_response_rate", this.host_response_rate);
    __sqoop$field_map.put("host_since", this.host_since);
    __sqoop$field_map.put("instant_bookable", this.instant_bookable);
    __sqoop$field_map.put("last_review", this.last_review);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("name", this.name);
    __sqoop$field_map.put("neighbourhood", this.neighbourhood);
    __sqoop$field_map.put("number_of_reviews", this.number_of_reviews);
    __sqoop$field_map.put("review_scores_rating", this.review_scores_rating);
    __sqoop$field_map.put("thumbnail_url", this.thumbnail_url);
    __sqoop$field_map.put("zipcode", this.zipcode);
    __sqoop$field_map.put("bedrooms", this.bedrooms);
    __sqoop$field_map.put("beds", this.beds);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("log_price", this.log_price);
    __sqoop$field_map.put("property_type", this.property_type);
    __sqoop$field_map.put("room_type", this.room_type);
    __sqoop$field_map.put("amenities", this.amenities);
    __sqoop$field_map.put("accommodates", this.accommodates);
    __sqoop$field_map.put("bathrooms", this.bathrooms);
    __sqoop$field_map.put("bed_type", this.bed_type);
    __sqoop$field_map.put("cancellation_policy", this.cancellation_policy);
    __sqoop$field_map.put("cleaning_fee", this.cleaning_fee);
    __sqoop$field_map.put("city", this.city);
    __sqoop$field_map.put("description", this.description);
    __sqoop$field_map.put("first_review", this.first_review);
    __sqoop$field_map.put("host_has_profile_pic", this.host_has_profile_pic);
    __sqoop$field_map.put("host_identity_verified", this.host_identity_verified);
    __sqoop$field_map.put("host_response_rate", this.host_response_rate);
    __sqoop$field_map.put("host_since", this.host_since);
    __sqoop$field_map.put("instant_bookable", this.instant_bookable);
    __sqoop$field_map.put("last_review", this.last_review);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("name", this.name);
    __sqoop$field_map.put("neighbourhood", this.neighbourhood);
    __sqoop$field_map.put("number_of_reviews", this.number_of_reviews);
    __sqoop$field_map.put("review_scores_rating", this.review_scores_rating);
    __sqoop$field_map.put("thumbnail_url", this.thumbnail_url);
    __sqoop$field_map.put("zipcode", this.zipcode);
    __sqoop$field_map.put("bedrooms", this.bedrooms);
    __sqoop$field_map.put("beds", this.beds);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
