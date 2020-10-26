package org.hospitality.app.entity.user;

//Thaakir Ajouhaar 217244394

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StayInformation
{
    @Id
    private String occupantNumber ;
    private String occupantId ;
    private String stayDuration ;
    private String deliveries ;

    protected StayInformation()
    {

    }

    private StayInformation(Builder builder)
    {
        this.occupantNumber = builder.occupantNumber ;
        this.occupantId = builder.occupantId ;
        this.stayDuration = builder.stayDuration ;
        this.deliveries = builder.deliveries ;

    }

    public String getOccupantNumber()
    {
        return occupantNumber;
    }

    public String getOccupantId()
    {
        return occupantId;
    }

    public String getStayDuration()
    {
        return stayDuration;
    }

    public String getDeliveries()
    {
        return deliveries;
    }

    @Override
    public String toString()
    {
        return "StayInformation{" +
                "occupantNumber='" + occupantNumber + '\'' +
                ", occupantId='" + occupantId + '\'' +
                ", stayDuration='" + stayDuration + '\'' +
                ", deliveries='" + deliveries + '\'' +
                '}';
    }

    public static class Builder
    {
        private String occupantNumber , occupantId , stayDuration , deliveries ;

        public Builder setOccupantNumber(String occupantNumber)
        {
            this.occupantNumber = occupantNumber;
            return this;
        }

        public Builder setOccupantId(String occupantId)
        {
            this.occupantId = occupantId;
            return this;
        }

        public Builder setStayDuration(String stayDuration)
        {
            this.stayDuration = stayDuration;
            return this;
        }

        public Builder setDeliveries(String deliveries)
        {
            this.deliveries = deliveries;
            return this;
        }

        public Builder copy(StayInformation stayInformation)
        {
            this.occupantNumber = stayInformation.occupantNumber;
            this.occupantId = stayInformation.occupantId;
            this.stayDuration = stayInformation.stayDuration;
            this.deliveries = stayInformation.deliveries;

            return this;
        }

        public StayInformation build(){
            return new StayInformation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StayInformation that = (StayInformation) o;
        return occupantId.equals(that.occupantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(occupantId);
    }
}
