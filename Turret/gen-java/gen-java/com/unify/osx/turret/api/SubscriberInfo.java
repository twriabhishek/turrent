/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.unify.osx.turret.api;

/**
 * Contains information required to be able to subscribe for notifications.
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2023-09-29")
public class SubscriberInfo implements org.apache.thrift.TBase<SubscriberInfo, SubscriberInfo._Fields>, java.io.Serializable, Cloneable, Comparable<SubscriberInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SubscriberInfo");

  private static final org.apache.thrift.protocol.TField IP_ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("ipAddress", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("port", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TURRET_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("turretName", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SubscriberInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SubscriberInfoTupleSchemeFactory();

  /**
   * Specifies the notification receiver's IP address
   */
  public @org.apache.thrift.annotation.Nullable java.lang.String ipAddress; // required
  /**
   * Specifies the port the receiver is listening on
   */
  public int port; // required
  /**
   * Notifications will contain this name for turret identification if the connecting client has to handle multiple turrets
   * at the same time.
   * This parameter is optional. If no turretName is provided, the notifications will be sent with an empty string as the name.
   */
  public @org.apache.thrift.annotation.Nullable java.lang.String turretName; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * Specifies the notification receiver's IP address
     */
    IP_ADDRESS((short)1, "ipAddress"),
    /**
     * Specifies the port the receiver is listening on
     */
    PORT((short)2, "port"),
    /**
     * Notifications will contain this name for turret identification if the connecting client has to handle multiple turrets
     * at the same time.
     * This parameter is optional. If no turretName is provided, the notifications will be sent with an empty string as the name.
     */
    TURRET_NAME((short)3, "turretName");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // IP_ADDRESS
          return IP_ADDRESS;
        case 2: // PORT
          return PORT;
        case 3: // TURRET_NAME
          return TURRET_NAME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PORT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TURRET_NAME};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.IP_ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("ipAddress", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PORT, new org.apache.thrift.meta_data.FieldMetaData("port", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TURRET_NAME, new org.apache.thrift.meta_data.FieldMetaData("turretName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SubscriberInfo.class, metaDataMap);
  }

  public SubscriberInfo() {
    this.turretName = "";

  }

  public SubscriberInfo(
    java.lang.String ipAddress,
    int port)
  {
    this();
    this.ipAddress = ipAddress;
    this.port = port;
    setPortIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SubscriberInfo(SubscriberInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetIpAddress()) {
      this.ipAddress = other.ipAddress;
    }
    this.port = other.port;
    if (other.isSetTurretName()) {
      this.turretName = other.turretName;
    }
  }

  @Override
  public SubscriberInfo deepCopy() {
    return new SubscriberInfo(this);
  }

  @Override
  public void clear() {
    this.ipAddress = null;
    setPortIsSet(false);
    this.port = 0;
    this.turretName = "";

  }

  /**
   * Specifies the notification receiver's IP address
   */
  @org.apache.thrift.annotation.Nullable
  public java.lang.String getIpAddress() {
    return this.ipAddress;
  }

  /**
   * Specifies the notification receiver's IP address
   */
  public SubscriberInfo setIpAddress(@org.apache.thrift.annotation.Nullable java.lang.String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

  public void unsetIpAddress() {
    this.ipAddress = null;
  }

  /** Returns true if field ipAddress is set (has been assigned a value) and false otherwise */
  public boolean isSetIpAddress() {
    return this.ipAddress != null;
  }

  public void setIpAddressIsSet(boolean value) {
    if (!value) {
      this.ipAddress = null;
    }
  }

  /**
   * Specifies the port the receiver is listening on
   */
  public int getPort() {
    return this.port;
  }

  /**
   * Specifies the port the receiver is listening on
   */
  public SubscriberInfo setPort(int port) {
    this.port = port;
    setPortIsSet(true);
    return this;
  }

  public void unsetPort() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  /** Returns true if field port is set (has been assigned a value) and false otherwise */
  public boolean isSetPort() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  public void setPortIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PORT_ISSET_ID, value);
  }

  /**
   * Notifications will contain this name for turret identification if the connecting client has to handle multiple turrets
   * at the same time.
   * This parameter is optional. If no turretName is provided, the notifications will be sent with an empty string as the name.
   */
  @org.apache.thrift.annotation.Nullable
  public java.lang.String getTurretName() {
    return this.turretName;
  }

  /**
   * Notifications will contain this name for turret identification if the connecting client has to handle multiple turrets
   * at the same time.
   * This parameter is optional. If no turretName is provided, the notifications will be sent with an empty string as the name.
   */
  public SubscriberInfo setTurretName(@org.apache.thrift.annotation.Nullable java.lang.String turretName) {
    this.turretName = turretName;
    return this;
  }

  public void unsetTurretName() {
    this.turretName = null;
  }

  /** Returns true if field turretName is set (has been assigned a value) and false otherwise */
  public boolean isSetTurretName() {
    return this.turretName != null;
  }

  public void setTurretNameIsSet(boolean value) {
    if (!value) {
      this.turretName = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case IP_ADDRESS:
      if (value == null) {
        unsetIpAddress();
      } else {
        setIpAddress((java.lang.String)value);
      }
      break;

    case PORT:
      if (value == null) {
        unsetPort();
      } else {
        setPort((java.lang.Integer)value);
      }
      break;

    case TURRET_NAME:
      if (value == null) {
        unsetTurretName();
      } else {
        setTurretName((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case IP_ADDRESS:
      return getIpAddress();

    case PORT:
      return getPort();

    case TURRET_NAME:
      return getTurretName();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case IP_ADDRESS:
      return isSetIpAddress();
    case PORT:
      return isSetPort();
    case TURRET_NAME:
      return isSetTurretName();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof SubscriberInfo)
      return this.equals((SubscriberInfo)that);
    return false;
  }

  public boolean equals(SubscriberInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_ipAddress = true && this.isSetIpAddress();
    boolean that_present_ipAddress = true && that.isSetIpAddress();
    if (this_present_ipAddress || that_present_ipAddress) {
      if (!(this_present_ipAddress && that_present_ipAddress))
        return false;
      if (!this.ipAddress.equals(that.ipAddress))
        return false;
    }

    boolean this_present_port = true;
    boolean that_present_port = true;
    if (this_present_port || that_present_port) {
      if (!(this_present_port && that_present_port))
        return false;
      if (this.port != that.port)
        return false;
    }

    boolean this_present_turretName = true && this.isSetTurretName();
    boolean that_present_turretName = true && that.isSetTurretName();
    if (this_present_turretName || that_present_turretName) {
      if (!(this_present_turretName && that_present_turretName))
        return false;
      if (!this.turretName.equals(that.turretName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetIpAddress()) ? 131071 : 524287);
    if (isSetIpAddress())
      hashCode = hashCode * 8191 + ipAddress.hashCode();

    hashCode = hashCode * 8191 + port;

    hashCode = hashCode * 8191 + ((isSetTurretName()) ? 131071 : 524287);
    if (isSetTurretName())
      hashCode = hashCode * 8191 + turretName.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(SubscriberInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetIpAddress(), other.isSetIpAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIpAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ipAddress, other.ipAddress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetPort(), other.isSetPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.port, other.port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTurretName(), other.isSetTurretName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTurretName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.turretName, other.turretName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SubscriberInfo(");
    boolean first = true;

    sb.append("ipAddress:");
    if (this.ipAddress == null) {
      sb.append("null");
    } else {
      sb.append(this.ipAddress);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("port:");
    sb.append(this.port);
    first = false;
    if (isSetTurretName()) {
      if (!first) sb.append(", ");
      sb.append("turretName:");
      if (this.turretName == null) {
        sb.append("null");
      } else {
        sb.append(this.turretName);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (ipAddress == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'ipAddress' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'port' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SubscriberInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public SubscriberInfoStandardScheme getScheme() {
      return new SubscriberInfoStandardScheme();
    }
  }

  private static class SubscriberInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<SubscriberInfo> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, SubscriberInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // IP_ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ipAddress = iprot.readString();
              struct.setIpAddressIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.port = iprot.readI32();
              struct.setPortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TURRET_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.turretName = iprot.readString();
              struct.setTurretNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetPort()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'port' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, SubscriberInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ipAddress != null) {
        oprot.writeFieldBegin(IP_ADDRESS_FIELD_DESC);
        oprot.writeString(struct.ipAddress);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PORT_FIELD_DESC);
      oprot.writeI32(struct.port);
      oprot.writeFieldEnd();
      if (struct.turretName != null) {
        if (struct.isSetTurretName()) {
          oprot.writeFieldBegin(TURRET_NAME_FIELD_DESC);
          oprot.writeString(struct.turretName);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SubscriberInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public SubscriberInfoTupleScheme getScheme() {
      return new SubscriberInfoTupleScheme();
    }
  }

  private static class SubscriberInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<SubscriberInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SubscriberInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.ipAddress);
      oprot.writeI32(struct.port);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTurretName()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetTurretName()) {
        oprot.writeString(struct.turretName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SubscriberInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.ipAddress = iprot.readString();
      struct.setIpAddressIsSet(true);
      struct.port = iprot.readI32();
      struct.setPortIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.turretName = iprot.readString();
        struct.setTurretNameIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

