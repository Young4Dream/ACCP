
package com.pb.blog.entity;

public class SiteConfig extends BaseDomain {
	
	private static final long serialVersionUID = -814103622204673794L;

	
	private String siteName;
	

	private String siteAbout;
	private static final String APP_VERSION = "1.0";
	
	private String theme;
	
	public SiteConfig(){
	}
	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSiteAbout() {
		return siteAbout;
	}

	public void setSiteAbout(String siteAbout) {
		this.siteAbout = siteAbout;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	
	@Override
	public String toString() {
		return this.siteName + "'s config";
	}
	
	/**
	 * get the smartblog's version.
	 * 
	 */
	public String getAppVersion() {
		return APP_VERSION;
	}
	
}
