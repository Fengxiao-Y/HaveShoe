package com.yidu.avg.pojo;

import java.io.Serializable;

public class Usershoe implements Serializable {
	private static final long serialVersionUID = 1L;
	private int usId;
	private String usName;
	private String usPwd;
	private String usSex;
	private String usEmail;
	private String usAddress;
	private String usPhone;
	private String usPostal;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Usershoe() {
	
	}
	
	
	public Usershoe(String usName, String usEmail, String usPhone) {
		super();
		this.usName = usName;
		this.usEmail = usEmail;
		this.usPhone = usPhone;
	}


	/**
	 * Ĭ�ϴ��η���
	 * @param usName �û���
	 * @param usPwd �û�����
	 * @param usSex �û��Ա�
	 * @param usEmail �û�����
	 * @param usAddress �û���ַ
	 * @param usPhone �û��绰
	 * @param usPostal �ʱ�
	 */
	public Usershoe(String usName, String usPwd, String usSex, String usEmail, String usAddress,
			String usPhone, String usPostal) {
		this.usName = usName;
		this.usPwd = usPwd;
		this.usSex = usSex;
		this.usEmail = usEmail;
		this.usAddress = usAddress;
		this.usPhone = usPhone;
		this.usPostal = usPostal;
	}

	public Usershoe(String usName, String usPwd) {
		
		this.usName = usName;
		this.usPwd = usPwd;
	}
	
	
	@Override
	public String toString() {
		return "Usershoe [usId=" + usId + ", usName=" + usName + ", usPwd=" + usPwd + ", usSex=" + usSex + ", usEmail="
				+ usEmail + ", usAddress=" + usAddress + ", usPhone=" + usPhone + ", usPostal=" + usPostal + "]";
	}
	/**
	 * Ĭ�ϴ��η���
	 * @param usId �û�id
	 * @param usName �û���
	 * @param usPwd �û�����
	 * @param usSex �û��Ա�
	 * @param usEmail �û�����
	 * @param usAddress �û���ַ
	 * @param usPhone �û��绰
	 * @param usPostal �ʱ�
	 */
	public Usershoe(int usId, String usName, String usPwd, String usSex, String usEmail, String usAddress,
			String usPhone, String usPostal) {
		this.usId = usId;
		this.usName = usName;
		this.usPwd = usPwd;
		this.usSex = usSex;
		this.usEmail = usEmail;
		this.usAddress = usAddress;
		this.usPhone = usPhone;
		this.usPostal = usPostal;
	}

	/**
	 * �Զ�����getter��setter����
	 * @return
	 */
	public int getUsId() {
		return usId;
	}

	public void setUsId(int usId) {
		this.usId = usId;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getUsPwd() {
		return usPwd;
	}

	public void setUsPwd(String usPwd) {
		this.usPwd = usPwd;
	}

	public String getUsSex() {
		return usSex;
	}

	public void setUsSex(String usSex) {
		this.usSex = usSex;
	}

	public String getUsEmail() {
		return usEmail;
	}

	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}

	public String getUsAddress() {
		return usAddress;
	}

	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}

	public String getUsPhone() {
		return usPhone;
	}

	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}

	public String getUsPostal() {
		return usPostal;
	}

	public void setUsPostal(String usPostal) {
		this.usPostal = usPostal;
	}
	
	
	
}
