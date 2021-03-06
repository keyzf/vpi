package press.whcj.ams.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author xyyxhcj@qq.com
 * @since 2019/12/31
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = -2750695756940876706L;
	private String id;
	private String userName;
	private String loginName;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private Byte isAdmin;
	private String phone;
	private String email;
	private String avatarUrl;
	private String remark;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	@DBRef
	@JsonBackReference("create")
	private User create;
	@DBRef
	@JsonBackReference("update")
	private User update;
	@Transient
	private Byte userType;
	@Transient
	private String projectUserId;

	public User(String id) {
		this.id = id;
	}

	public String getCreateId() {
		return create == null ? null : create.getId();
	}

	public String getCreateName() {
		return create == null ? null : create.getUserName();
	}

	public String getUpdateId() {
		return update == null ? null : update.getId();
	}

	public String getUpdateName() {
		return update == null ? null : update.getUserName();
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", loginName='" + loginName + '\'' +
				", password='" + password + '\'' +
				", isAdmin=" + isAdmin +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", avatarUrl='" + avatarUrl + '\'' +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", createId=" + getCreateId() +
				", createName=" + getCreateName() +
				", updateId=" + getUpdateId() +
				", updateName=" + getUpdateName() +
				", userType=" + userType +
				", projectUserId='" + projectUserId + '\'' +
				'}';
	}
}
