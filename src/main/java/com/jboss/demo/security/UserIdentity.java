package com.jboss.demo.security;

public class UserIdentity
{
    private String accountId;

    private String principalId;

    private String accessKeyId;

    private String userName;

    private String arn;

    private String type;

    public String getAccountId ()
    {
        return accountId;
    }

    public void setAccountId (String accountId)
    {
        this.accountId = accountId;
    }

    public String getPrincipalId ()
    {
        return principalId;
    }

    public void setPrincipalId (String principalId)
    {
        this.principalId = principalId;
    }

    public String getAccessKeyId ()
    {
        return accessKeyId;
    }

    public void setAccessKeyId (String accessKeyId)
    {
        this.accessKeyId = accessKeyId;
    }

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public String getArn ()
    {
        return arn;
    }

    public void setArn (String arn)
    {
        this.arn = arn;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [accountId = "+accountId+", principalId = "+principalId+", accessKeyId = "+accessKeyId+", userName = "+userName+", arn = "+arn+", type = "+type+"]";
    }
}