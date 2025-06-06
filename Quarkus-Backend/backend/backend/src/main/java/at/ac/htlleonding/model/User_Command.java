package at.ac.htlleonding.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name=User_Command.QUERY_FIND_ALL_PERSONALIZED_BY_USERID, query="SELECT c FROM Command c JOIN User_Command uc ON c.id = uc.command.id WHERE uc.user.id = :id")
})
public class User_Command {

    public static final String QUERY_FIND_ALL_PERSONALIZED_BY_USERID = "User_Command.findByUserId";

    @EmbeddedId
    @AttributeOverride(name="userId", column=@Column(name="user_id"))
    @AttributeOverride(name="commandId", column = @Column(name="command_id"))
    private UserCommandId userCommandId;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("commandId")
    private Command command;

    //it is "default" or "personalised"
    //private String type;

    public User_Command() {
    }

    public User_Command(User user, Command command /*, String type*/) {
        this.user = user;
        this.command = command;
        this.userCommandId = new UserCommandId(user.getId(), command.getId());
    }

    public UserCommandId getUserCommandId() {
        return userCommandId;
    }

    public void setUserCommandId(UserCommandId userCommandId) {
        this.userCommandId = userCommandId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

}
