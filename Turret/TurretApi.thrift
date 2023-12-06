namespace cpp osxpert.turret.api
namespace java com.unify.osx.turret.api
namespace  py   unify.osx.turret.api

//Types
typedef string LineName
typedef i16 SpeechUnitId
typedef i32 TurretErrorCode

//Constants

// General error codes
/** Action performed successfully */
    const i32 Ok                   = 0;
/** One of the provided arguments has invalid value. Please refer to the description of the called function for more information. */
    const i32 InvalidArgument      = 1;
/** No speech unit exists with the provided id. */
    const i32 InvalidSpeechUnit    = 2;
/** The requested action can not be performed in the current login state. */
    const i32 WrongLoginState      = 3;
/** The request could not be forwarded to an external component (System Manager or MLC) */
    const i32 CannotSendRequest    = 4;
/** The provided line is not available at the moment. Check connection to MLC. */
    const i32 LineUnavailable      = 5;
/** The provided line is already in use for another call. */
    const i32 LineBusy             = 6;
/** The provided speech unit is already in use for another call. */
    const i32 SpeechUnitBusy       = 7;
/** There is no line available with the provided line name. */
    const i32 InvalidLine          = 8;
/** There are no incoming calls on any line on the profile. */
    const i32 NoIncomingCall       = 9;
/** No call can be picked up from the requested line as it is in idle state. */
    const i32 LineIsNotRinging     = 10;
/** The requested action can not be performed because there is no call on the provided speech unit. */
    const i32 SpeechUnitHasNoCall  = 11;
/** There are no free lines available to perform the requested action. */
    const i32 NoFreeLineAvailable  = 12;
/** The specified action can not be performed */
    const i32 FunctionUnavailable  = 13;
/** There is no consultation  */
    const i32 NoConsultation       = 14;
/** The Line is not in hold. */
    const i32 LineIsNotInHold      = 15;

// Login response codes
/** The provided login data is correct, the login process has been finished, the software is ready for use. */
    const i32 LoginSuccessful      = 400;
/** Connection to the System Manager has been lost. */
    const i32 NoConnectionToSm     = 401;
/** The provided username and/or password is incorrect. */
    const i32 AuthenticationFailed = 402;
/** The requested action failed due to a System Manager database operation error. */
    const i32 DatabaseError        = 403;
/** No profile could be found with the specified name. */
    const i32 UnknownProfile       = 404;
/** There was an error during the ldap authentication. */
    const i32 LdapError            = 405;
/** The request was refused by the License Server. */
    const i32 LicenseNotAvailable  = 406;
/** There was an error loading the certificate files for Thrift TLS notifications. */
    const i32 LoadTLSCertError     = 407;

// Action error codes
/** No ring transfer could be found with the provided identifier. */
    const i32 InvalidRingTransfer = 600;
/** The specified ring transfer is only for signalization, state can not be changed. */
    const i32 RingTransferIsOnlyForSignalization = 601;
/** The specified ring transfer is already in the requested state. */
    const i32 RingTransferIsAlreadyInThatState = 602;
/** The specified ring transfer not exists on the server. Try refreshing the config or contacting the system administrator. */
    const i32 RingTransferIsMissingOnServer = 603;
/** The specified ring transfer could not be activated because there this ring transfer is not configured on the controlled profile. Contact the system administrator. */
    const i32 RingTransferHasNoLocalInstance = 604;
/** The specified ring transfer could not be activated because the controlled profile is logged out. */
    const i32 RingTransferControlledProfileLoggedOut = 605;
/** The specified ring transfer could not be deactivated because it is the last active ring transfer in a keep active group. */
    const i32 RingTransferKagConflict = 606;
/** The ring transfer state change request timed out. */
    const i32 RingTransferStateChangeTimeout = 607;

/** No ring transfer sequence could be found with the provided identifier. */
    const i32 InvalidRingTransferSequence = 620;
/** The specified ring transfer sequence is only for signalization, state can not be changed. */
    const i32 RingTransferSequenceIsOnlyForSignalization = 621;
/** The specified ring transfer sequence is already in the requested state. */
    const i32 RingTransferSequenceIsAlreadyInThatState = 622;
/** The specified ring transfer sequence cannot be deactivated directly because it is not configured for inverting behavior. */
    const i32 RingTransferSequenceIsNotInverting = 623;
/** The specified ring transfer sequence not exists on the server. Try refreshing the config or contacting the system administrator. */
    const i32 RingTransferSequenceIsMissingOnServer = 624;
/** The ring transfer sequence state change request timed out. */
    const i32 RingTransferSequenceStateChangeTimeout = 625;

/** No interface action could be found with the provided api name. */
    const i32 InvalidInterfaceAction = 640;
/** The specified interface action is only for signalization, state can not be changed. */
    const i32 InterfaceActionIsOnlyForSignalization = 641;
/** The specified interface action is already in the requested state. */
    const i32 InterfaceActionIsAlreadyInThatState = 642;
/** The requested state can not be set for the specified interface action. */
    const i32 InvalidInterfaceActionState = 643;
/** Unexpected error has occured */
    const i32 Unknown              = 9999;

//Enums
enum TurretState
{
  /** The turret is logged out */
  Logout = 0,
  /** The turret is in Receive Calls Only mode */
  ReceiveCallsOnly = 1,
  /** The turret is logged in with a profile */
  Login = 2,
  Unknown = 0xff
}

enum DeviceType {
  Handset = 0,
  Headset = 1,
  MicrophoneWithoutSpeaker = 2,
  MicrophoneWithSpeaker = 3
}

enum BasicLineState
{
  /** No activity on the line */
  Idle,
  /** There is an incoming call on the line */
  Ringing,
  /** The line is considered as connected */
  Connected,
  /** There is an ongoing call on the line on this device */
  Conversation,
  /** There is an ongoing call on the line on another device */
  ConversationByAnother,
  /** The call on this line is put on hold by this device, and the conversation partner isn't notified about this */
  PrivateHold,
  /** The call on this line is put on hold by another device, and the conversation partner isn't notified about this */
  PrivateHoldByAnother,
  /** The call on this line is put on hold by this device */
  CommonHold,
  /** The call on this line is put on hold by another device */
  CommonHoldByAnother,
  /** The call is private for this device, and cannot be accessed by other devices */
  Privacy,
  /** The call is private for another device, and cannot be accessed by this device */
  PrivacyByAnother,
  /** The line is assigned to a speech monitoring channel by this device, and is not present on any speech unit */
  SpeechMonitoring,
  /** This line is hosting a conference that is put on hold */
  ConferenceHold,
  /** The line is unavailable due to connection error */
  Inactive,
  /** The line is assigned to a speech monitoring channel by another device */
  SpeechMonitoringByAnother,
  /** There is an active announcement on the line */
  Announcement,
  /** The line is reserved to be used by this device, and cannot be accessed by other devices */
  Preseized,
  /** The line is reserved to be used by another device, and cannot be accessed by this device */
  PreseizedByAnother,
  /** The line is the host of a quick conference */
  HostingQuickConference,
  /** The line is the host of a consultation */
  HostingConsultation,
  /** The line is the host of a PBX conference */
  HostingPbxConference,
  /** The line has a consultation call that was answered by the called party */
  ConsultationConnected,

  Unknown = 0xff
}

enum RingTransferState
{
/** The ring transfer state is active */
  Active,
  /** The ring transfer state is inactive */
  Inactive
}

enum RingTransferSequenceState
{
  /** The ring transfer sequence state is active */
  Active,
  /** The ring transfer sequence state is inactive */
  Inactive,
  /** The ring transfer sequence state is partially (some of the ring transfers are in the required state, but not all of them) */
  PartiallyActive
}

enum InterfaceActionStateValue
{
  /** The interface action state is active */
  Active,
  /** The interface action state is inactive */
  Inactive,
  /** The interface action state is 'A' */
  State_A,
  /** The interface action state is 'B' */
  State_B,
  /** The interface action state is 'C' */
  State_C,
  /** The interface action state is 'D' */
  State_D,
  /** The interface action state is 'E' */
  State_E,
  /** The interface action state is 'F' */
  State_F,
  /** The interface action state is 'G' */
  State_G,
  /** The interface action state is 'H' */
  State_H,
  /** The interface action state is 'I' */
  State_I,
  /** The interface action state is 'J' */
  State_J,
  /** The interface action state is 'K' */
  State_K,
  /** The interface action state is 'L' */
  State_L,
  /** The interface action state is 'M' */
  State_M,
  /** The interface action state is 'N' */
  State_N,
  /** The interface action state is 'O' */
  State_O,
  /** The interface action state is 'P' */
  State_P,
  /** The interface action state is 'Q' */
  State_Q,
  /** The interface action state is 'R' */
  State_R,
  /** The interface action state is 'S' */
  State_S,
  /** The interface action state is 'T' */
  State_T,
  /** The interface action state is 'U' */
  State_U,
  /** The interface action state is 'V' */
  State_V,
  /** The interface action state is 'W' */
  State_W,
  /** The interface action state is 'X' */
  State_X,
  /** The interface action state is 'Y' */
  State_Y,
  /** The interface action state is 'Z' */
  State_Z
}

enum InterfaceActionKeyState
{
  /** A push type key is pressed */
  Pressed
  /** A push type key is released */
  Released
  /** A switch type key is pressed */
  Clicked
}

//Structs

/**
* Contains the name of the profile
*/
struct ProfileInfo {
  1: required string name
}

/**
* Contains the identifier and device type of a speech unit
* Used for getting speech unit configuration
*/
struct SpeechUnitConfiguration {
  1: required SpeechUnitId id
  2: required DeviceType deviceType
}

/**
* Contains the name of a line and the composite state of the line.
* Used for snapshots about lines, and notification about state changes of the line.
*/
struct LineStatesData
{
  /** Unique name of the line */
  1: required LineName lineName ( )
  /** Set of BasicLineStates of the line (as they are not all mutually exclusive) */
  2: required set<BasicLineState> basicLineStates
}

/**
* Contains information required to be able to subscribe for notifications.
*/
struct SubscriberInfo
{
  /** Specifies the notification receiver's IP address */
  1: required string ipAddress
  /** Specifies the port the receiver is listening on */
  2: required i32 port
  /** Notifications will contain this name for turret identification if the connecting client has to handle multiple turrets
  * at the same time.
  * This parameter is optional. If no turretName is provided, the notifications will be sent with an empty string as the name.
  */
  3: optional string turretName = ""
}

/**
* Contains information regarding calls.
*
*    **Note:** The GUI shows this information in the following way:
*    #. if :thrift:struct_field:`TurretApi.CallData.contactName` is not empty, then it is displayed.
*    #. if :thrift:struct_field:`TurretApi.CallData.partyName` is not empty, then ``"{partyNumber} {partyName}"`` is displayed.
*    #. in other cases, the :thrift:struct_field:`TurretApi.CallData.partyNumber` is diplayed.
*/
struct CallData {
  /** Name of the line the call is initiated from. */
  1: required LineName lineName
  /** Number of the other party. */
  2: required string partyNumber
  /** Name of the other party as provided by the PBX, encoded in UTF-8. */
  3: required string partyName
  /** Name of the other party resolved from the contact list, encoded in UTF-8. */
  4: required string contactName
  /** Identifier of the call, unique in the context of the line. */
  5: required string callId
  /** `true` if this call is active on the line (i.e. it is not in the background in case of consultation) */
  6: required bool active
}

/**
* Contains information required to identify a ring transfer or a ring transfer sequence
*/
struct RingTransferId
{
  /**
  * The API name of the ring transfer
  */
  1: required string apiName;
  /**
  * The name of the controlled profile
  */
  2: required string controlledProfileName;
}

/**
* Contains information about an interface action's state and the texts displayed on its button
*/
struct InterfaceActionState
{
  /**
  * The state of the ring transfer
  */
  1: required InterfaceActionStateValue state,
  /**
  * The overriding text for 'label'.
  * Overriding means that it is an empty string in case of default text.
  * It is optional only when used in setInterfaceActionState.
  */
  2: optional string labelText,
  /**
  * The text displayed on the first line.
  * Overriding means that it is an empty string in case of default text.
  * It is optional only when used in setInterfaceActionState.
  */
  3: optional string firstLineText,
  /**
  * The text displayed on the second line.
  * Overriding means that it is an empty string in case of default text.
  * It is optional only when used in setInterfaceActionState.
  */
  4: optional string secondLineText
}

/**
* Exception type used to indicate that an error has occured.
*/
exception TurretApiException
{
  /** Unique number indicating the error */
  1: required TurretErrorCode ErrorCode
  /** Short description of the problem, useful for logging */
  2: required string ErrorAsString
}

//Services
service TurretRequestService {
  /**
  * Requests notifications about line state change, login state change, login errors and change on top of call queue.
  */
  void requestNotifications(
    /** SubscriberInfo IP address and port of the requesting client; Optionally contains turret display name */
    1: SubscriberInfo subscriberInfo)
  throws (1: TurretApiException ex)

  /**
  * Requests and returns the list of the available profiles
  */
  list<ProfileInfo> getProfileList()

  /**
  * Requests and returns the name of the currently logged in profile
  */
  string getLoggedInProfileName()
    throws (
    /** :thrift:constant:`TurretApi.WrongLoginState` the turret is neither logged in nor in RCO mode */
      1: TurretApiException ex)

  /**
  * Requests and returns the current speech unit configuration setup in the system for the actual client.
  *
  * See :thrift:struct:`TurretApi.SpeechUnitConfiguration` for included information.
  */
  list<SpeechUnitConfiguration> getSpeechUnits()
    throws (
    /** :thrift:constant:`TurretApi.WrongLoginState` if the turret is not logged in */
      1: TurretApiException ex)

  /**
  * Requests and returns a list about the identifiers of the available lines.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if the turret is logged out.
  */
  list<LineName> getAvailableLines() throws (1: TurretApiException ex)

  /**
  * Requests the state of the line specified by lineName.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if the turret is logged out or line name is invalid.
  */
  LineStatesData snapshotLineRequest(
    /** Identifier of the requested line */
    1: LineName lineName)
  throws (1: TurretApiException ex)

  /**
  * Request the state of the current calls.
  * See :thrift:struct:`TurretApi.CallData` for the included information.
  */
  list<CallData> snapshotCalls()

  /**
  * Requests the turret to log in with the specified profile name and password.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if the turret is already logged in.
  * A successful call of this function only means that the request is forwarded to the System Manager;
  * The actual response will arrive in a login response notification
  * (see :thrift:service_method:`TurretApi.TurretNotificationService.onLoginResponse`)
  */
  void login(
    /** Name of the profile */
    1: string profileName,
    /** Profile's password */
    2: string password)
  throws (1: TurretApiException ex)

  /**
  * Requests the turret to log out of the currently logged in profile.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if the turret is already logged out.
  */
  void logout() throws (1: TurretApiException ex)

  /**
  * Requests the turret to dial the given number from the specified speech unit.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if speech unit id is invalid, the speech unit is busy or there is
  * no free line to initiate a call from.
  */
  void makeCall(
    /** Speech unit identifier */
    1: SpeechUnitId suId,
    /** Telephone number to call */
    2: string number)
  throws (1: TurretApiException ex)

  /**
  * Requests the turret to dial the given number from the specified speech unit using a certain line.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if speech unit id or lineName is invalid, the speech unit or line is
  * busy or the line is unavailable.
  */
  void makeCallFromSpecificLine(
    /** Speech unit identifier */
    1: SpeechUnitId suId,
    /** Line identifier from which the call will be initiated */
    2: LineName lineName,
    /** Telephone number to call */
    3: string number)
  throws (1: TurretApiException ex)

  /**
  * Request the turret to create a *Consultation* on ``suId`` by calling ``number``.
  * It is prerequisite that there is a line on ``suId`` and it is ``Connected``.
  */
  void createConsultation(
    /** Speech unit identifier */
    1: SpeechUnitId suId,
    /** Telephone number to call */
    2: string number)
  throws (1: TurretApiException ex)

  /**
  * Request the turret to execute *Transfer* on the given ``suId``.
  * The line seized on ``suId`` must have the ``HostingConsultation`` state.
  */
  void transfer(
    /** Speech unit identifier */
    1: SpeechUnitId suId)
  throws (1: TurretApiException ex)

  /**
  * Request the turret to execute *Toggle* on the given ``suId``.
  * The line seized on ``suId`` must have the ``HostingConsultation`` state.
  */
  void toggle(
    /** Speech unit identifier */
    1: SpeechUnitId suId)
  throws (1: TurretApiException ex)

  /**
  * Request the turret to create a *PBX Conference* (max. 3 participants) on the given ``suId``.
  * The line seized on ``suId`` must have the ``HostingConsultation`` state.
  * If the request was successful, the line on the given ``suId`` will have the ``HostingPbxConference`` state.
  */
  void pbxConference(
    /** Speech unit identifier */
    1: SpeechUnitId suId)
  throws(1: TurretApiException ex)

  /**
  * Answers the incoming call with the highest priority in the call queue.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if speech unit id is invalid or the speech unit is busy.
  */
  void answerCall(
    /** Receiver speech unit's identifier */
    1: SpeechUnitId suId)
  throws (1: TurretApiException ex)

  /**
  * Answers the incoming call on the line specified by lineName.
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if speech unit id or lineName is invalid, the speech unit is busy or
  * there is no incoming call on the specified line.
  */
  void answerSpecificCall(
    /** Receiver speech unit's identifier */
    1: SpeechUnitId suId,
    /** Ringing line's identifier which will be picked up */
    2: LineName lineName)
  throws (1: TurretApiException ex)

  /**
  * Disconnects the call present on the speech unit specified by suId
  * :thrift:struct:`TurretApi.TurretApiException` is thrown if the speech unit id is invalid, there is no ongoing call on the speech unit,
  * or the turret is not logged in.
  */
  void disconnectCall(
    /** Receiver speech unit's identifier */
    1: SpeechUnitId suId)
  throws (1: TurretApiException ex)

  /**
  * Puts the call on hold from the given speech unit.
  *
  * Possible values for :thrift:struct_field:`TurretApi.TurretApiException.ErrorCode`:
  *     #. :thrift:constant:`TurretApi.InvalidSpeechUnit` speech unit id is invalid
  *     #. :thrift:constant:`TurretApi.SpeechUnitHasNoCall` there is no call on the given speech unit,
  *     #. :thrift:constant:`TurretApi.FunctionUnavailable` the hold function is unavailable
  */
  void hold(
  /** Speech unit identifier */
    1: SpeechUnitId suId)
    throws (1: TurretApiException ex)

  /**
  * Put the call on the specified speech unit to common (SIP) hold, ie. hold on all turret subscribed to the line.
  *
  * Possible values for :thrift:struct_field:`TurretApi.TurretApiException.ErrorCode`:
  *     #. :thrift:constant:`TurretApi.InvalidSpeechUnit` speech unit id is invalid
  *     #. :thrift:constant:`TurretApi.SpeechUnitHasNoCall` there is no call on the given speech unit,
  *     #. :thrift:constant:`TurretApi.FunctionUnavailable` the common hold function is unavailable
  *     #. :thrift:constant:`TurretApi.FunctionUnavailable` the hold behaviour is set to private.
  */
  void commonHold(
  /** Speech unit identifier */
    1: SpeechUnitId suId)
    throws (1: TurretApiException ex)

  /**
  * Puts the call on private hold from the given speech unit.
  *
  * Possible values for :thrift:struct_field:`TurretApi.TurretApiException.ErrorCode`:
  *     #. :thrift:constant:`TurretApi.InvalidSpeechUnit` speech unit id is invalid
  *     #. :thrift:constant:`TurretApi.SpeechUnitHasNoCall` there is no call on the given speech unit,
  *     #. :thrift:constant:`TurretApi.FunctionUnavailable` the private hold function is unavailable
  */
  void privateHold(
  /** Speech unit identifier */
    1: SpeechUnitId suId)
    throws (1: TurretApiException ex)

  /**
  * Retrieves the call from hold to the given speech unit.
  *
  * Possible values for :thrift:struct_field:`TurretApi.TurretApiException.ErrorCode`:
  *     #. :thrift:constant:`TurretApi.InvalidSpeechUnit` speech unit id is invalid
  *     #. :thrift:constant:`TurretApi.InvalidLine` the lineName is invalid
  *     #. :thrift:constant:`TurretApi.LineIsNotInHold` the line is not in hold
  */
  void retrieveSpecific(
  /** Speech unit identifier */
    1: SpeechUnitId suId,
  /** Unique name of the Line */
    2: LineName lineName)
    throws (1: TurretApiException ex)

  /**
  * Sends DTMF on the line which is connected on the specified speech unit.
  *
  * Possible values for :thrift:struct_field:`TurretApi.TurretApiException.ErrorCode`:
  *    #. :thrift:constant:`TurretApi.InvalidArgument` digit is not a valid DTMF digit
  *    #. :thrift:constant:`TurretApi.InvalidSpeechUnit` speech unit id is invalid
  *    #. :thrift:constant:`TurretApi.SpeechUnitHasNoCall` there is no call on the speech unit
  *    #. :thrift:constant:`TurretApi.FunctionUnavailable` the call does not accept DTMF
  */
  void dtmf(
    /** Speech unit identifier */
    1: SpeechUnitId suId,
    /** DTMF digit to send */
    2: i8 digit)
  throws (1: TurretApiException ex)

  /**
  * Requests the current login state of the turret
  */
  TurretState getLoginState()

  /**
  * Requests the version of the turret software.
  */
  string getVersion()

  /**
  * Requests the list of available ring transfers
  */
  list<RingTransferId> getAvailableRingTransfers() throws (1: TurretApiException ex);

  /**
  * Requests the current state of the ring transfer
  */
  RingTransferState snapshotRingTransfer(1: RingTransferId id) throws (1: TurretApiException ex);

  /**
  * Sets the ring transfer's state
  */
  void setRingTransferActive(1: RingTransferId id, 2: bool active) throws (1: TurretApiException ex);

  /**
  * Requests the list of available ring transfer sequences
  */
  list<RingTransferId> getAvailableRingtransferSequences() throws (1: TurretApiException ex);

  /**
  * Requests the current state of the ring transfer sequence
  */
  RingTransferSequenceState snapshotRingTransferSequence(1: RingTransferId id) throws (1: TurretApiException ex);

  /**
  * Sets the ring transfer sequence's state
  */
  void setRingTransferSequenceActive(1: RingTransferId id, 2: bool active) throws (1: TurretApiException ex);

  /**
  * Requests the list of available interface actions
  */
  list<string> getAvailableInterfaceActions() throws (1: TurretApiException ex);

  /**
  * Requests the current state of the interface action including the displayed texts
  */
  InterfaceActionState snapshotInterfaceAction(1: string apiName) throws (1: TurretApiException ex);

  /**
  * Sets the interface action's state
  * The texts within InterfaceActionState are optional. The texts are not changed if they are not specified.
  * The texts can be reset to their original value by setting an empty string.
  */
  void setInterfaceActionState(1: string apiName, 2: InterfaceActionState state) throws (1: TurretApiException ex);
}

service TurretNotificationService {
  /**
  * Notifies about the change of state of the specified line.
  */
  oneway void onLineStatesChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Contains the name and the new state of the line. */
    2: LineStatesData states)

  /**
  * .. deprecated:: V7.3.1
  *    Use :thrift:service_method:`TurretApi.TurretNotificationService.onCallDataChangedEx` instead.
  *
  * Notifies about the change of the possibly displayed name(s) of the line.
  * Note: The turret's GUI shows this information in the following way:
  *
  *     #. If ``contactName`` is not empty, then it is displayed.
  *     #. If ``partyName`` is not empty, then ``"{partyNumber} {partyName}"`` is displayed.
  *     #. In other cases, the ``partyNumber`` is diplayed.
  *
  */
  oneway void onCallDataChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Name of the line. */
    2: LineName lineName,
    /** Line number of the other party. */
    3: string partyNumber,
    /** Name of the line as provided by the PBX, encoded in UTF-8. */
    4: string partyName,
    /** Name of the calling party resolved from the contact list, encoded in UTF-8. */
    5: string contactName)

  /**
  * Notifies about the change in properties of a call.
  * See :thrift:struct:`TurretApi.CallData` for the included information.
  */
  oneway void onCallDataChangedEx(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    2: CallData callData)

  /**
  * Notifies about the login state change of the turret software.
  */
  oneway void onLoginStateChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** New login state of the turret. */
    2: TurretState state)

  /**
  * Notifies about an error during the login process
  */
  oneway void onLoginResponse(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Error code (see :ref:`Constants`)*/
    2: TurretErrorCode errorCode,
    /** Short text description of the error */
    3: string errorDescription)

  /**
  * Notifies a new incoming call having higher priority than the ones before, or
  * if all incoming calls have been removed from the call queue
  */
  oneway void onTopOfCallQueueChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Name of the line at the top of the call queue or an empty string if there is none. */
    2: LineName lineName)

  /**
  * Notifies a ring transfer state change.
  */
  oneway void onRingTransferStateChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Identifier of the ring transfer */
    2: RingTransferId id,
    /** The new state of the ring transfer */
    3: RingTransferState state)

  /**
  * Notifies that a previous request to change the activation of a ring transfer has failed.
  * (See :thrift:service_method:`TurretApi.TurretRequestService.setRingTransferActive`.)
  */
  oneway void onRingTransferStateChangeError(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Identifier of the ring transfer */
    2: RingTransferId id,
    /** Error code (see :thrift:typedef:`TurretApi.TurretErrorCode`)*/
    3: TurretErrorCode errorCode,
    /** Short text description of the error */
    4: string errorDescription)

  /**
  * Notifies a ring transfer sequence state change.
  */
  oneway void onRingTransferSequenceStateChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Identifier of the ring transfer sequence */
    2: RingTransferId id,
    /** The new state of the ring transfer sequence */
    3: RingTransferSequenceState state)

  /**
  * Notifies that a previous request to change the activation of a ring transfer sequence has failed.
  * (See :thrift:service_method:`TurretApi.TurretRequestService.setRingTransferSequenceActive`.)
  */
  oneway void onRingTransferSequenceStateChangeError(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Identifier of the ring transfer sequence */
    2: RingTransferId id,
    /** Error code (see :thrift:typedef:`TurretApi.TurretErrorCode`)*/
    3: TurretErrorCode errorCode,
    /** Short text description of the error */
    4: string errorDescription)

  /**
  * Notifies a interface action state change (including changes in the overriding texts).
  */
  oneway void onInterfaceActionStateChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Identifier of the interface action */
    2: string apiName,
    /** The new state of the interface action */
    3: InterfaceActionState state)

  /**
  * Notifies an interface action key event (press/release).
  */
  oneway void onInterfaceActionKeyChanged(
    /** Identifier of the turret specified at notification subscription.
    *   It's an empty string if no name was specified at subscription.
    */
    1: string turretName,
    /** Identifier of the interface action */
    2: string apiName,
    /** The key event */
    3: InterfaceActionKeyState keyState)
}
