Table User {
    id bigint [pk, increment]
    username varchar [unique]
    email varchar [unique]
    password varchar
}

Table Role {
    id bigint [pk, increment]
    role_name varchar [unique]
}

Table UserRole {
    user_id bigint [ref: > User.id]
    role_id bigint [ref: > Role.id]
}

Table Property {
    id bigint [pk, increment]
    title varchar
    description text
    price decimal
    property_type_id bigint [ref: > PropertyType.id]
    address_id bigint [ref: > Address.id]
    agent_id bigint [ref: > User.id]
}

Table PropertyType {
    id bigint [pk, increment]
    type_name varchar
}

Table Address {
    id bigint [pk, increment]
    street varchar
    city varchar
    state varchar
    country varchar
    zip_code varchar
}

Table Inquiry {
    id bigint [pk, increment]
    user_id bigint [ref: > User.id]
    property_id bigint [ref: > Property.id]
    message text
}

Table Contract {
    id bigint [pk, increment]
    buyer_id bigint [ref: > User.id]
    seller_id bigint [ref: > User.id]
    property_id bigint [ref: > Property.id]
    terms text
}

Table Transaction {
    id bigint [pk, increment]
    contract_id bigint [ref: > Contract.id]
    transaction_date date
    amount decimal
}

Table Payment {
    id bigint [pk, increment]
    transaction_id bigint [ref: > Transaction.id]
    payment_date date
    payment_method varchar
    amount decimal
}

Table Listing {
    id bigint [pk, increment]
    property_id bigint [ref: > Property.id]
    status_id bigint [ref: > ListingStatus.id]
    listing_date date
}

Table ListingStatus {
    id bigint [pk, increment]
    status_name varchar
}

Table Image {
    id bigint [pk, increment]
    property_id bigint [ref: > Property.id]
    url varchar
}

Table Review {
    id bigint [pk, increment]
    user_id bigint [ref: > User.id]
    property_id bigint [ref: > Property.id]
    rating int
    comment text
}

Table Favorite {
    user_id bigint [ref: > User.id]
    property_id bigint [ref: > Property.id]
}

Table Notification {
    id bigint [pk, increment]
    user_id bigint [ref: > User.id]
    message text
    notification_date date
}

